package com.channelsoft.usercenter.account.controller;

import com.alibaba.fastjson.JSONArray;
import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.account.po.status.UserType;
import com.channelsoft.usercenter.account.service.IEnterpriseMenuService;
import com.channelsoft.usercenter.account.service.IUserInfoService;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.util.EncryptUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月10日</dd>
 * </dl>
 *
 * @author 安宁
 */
@Controller
@RequestMapping("/")
public class UserController extends BaseController{
    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private IEnterpriseMenuService enterpriseMenuService;


    @RequestMapping("/login")
    public String login() {
        return "new_account/login";
    }

    @RequestMapping("/dologin")
    public String dologin(UserInfo userInfo, HttpSession session,HttpServletRequest request ,Integer remember) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                userInfo.getUserName(), EncryptUtils.encryptMD5(userInfo.getPassword()));
        if(remember != null && remember ==1){
            token.setRememberMe(true);
        }else{
            token.setRememberMe(false);
        }
        if (currentUser.isAuthenticated()) {
            return  "redirect:/index";
        }
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            logger.error(String.format("用户登录失败，userName:%s，password:%s,错误原因：%s", userInfo.getUserName(),userInfo.getPassword(),e.getMessage()));
            request.setAttribute("errorMessage", e.getMessage());
            return "new_account/login";
        }
        if (currentUser.isAuthenticated()) {
            userInfo = userInfoService.selectByUsername(userInfo.getUserName());
            session.setAttribute("userInfo", userInfo);
            SecurityUtils.getSubject().getSession().setAttribute("userInfo", userInfo);
            String jsonMenuList = enterpriseMenuService.getJsonMenuList(userInfo.getUserId(), userInfo.getEnterpriseId());
            JSONArray menuList = JSONArray.parseArray(jsonMenuList);
            SecurityUtils.getSubject().getSession().setAttribute("menuList", menuList);
            session.setAttribute("menuList", menuList);
            return "redirect:/index";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userInfo");
        session.removeAttribute("menuList");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "new_account/register";
    }

    @RequestMapping("/doregister")
    public String doregister(UserInfo userInfo, HttpSession session,HttpServletRequest request) {
        if(valiedeRegesterParam(session,request)){
            return "new_account/register";
        }
        userInfo.setPassword(EncryptUtils.encryptMD5(userInfo.getPassword()));
        userInfo.setUserType(UserType.CUSTOM_USER);
        int i = userInfoService.insertRegisterUserInfo(userInfo);
        if(i == 0){
            request.setAttribute("errorMessage","注册用户失败");
            return "new_account/register";
        }
        return "redirect:/login";
    }
    @RequiresAuthentication
    @RequestMapping("/alterpass")
    public String alterpass() {
        return "new_account/alterpass";
    }

    @RequiresAuthentication
    @RequestMapping("/doalterpass")
    public String doalterpass(UserInfo userInfo, HttpSession session,HttpServletRequest request) {
        String password = getUserInfo().getPassword();
        if(!password.equals(EncryptUtils.encryptMD5(request.getParameter("originPassword")))){
            request.setAttribute("errorMessage","您的密码不正确，请重新输入");
            return "new_account/alterpass";
        }
        if(!valideTwoPassword(session, request)){
            return "new_account/alterpass";
        }
        String newPassword = EncryptUtils.encryptMD5(userInfo.getPassword());
        userInfo.setPassword(newPassword);
        userInfo.setUserName(getUserInfo().getUserName());
        int i = userInfoService.updateUserPassword(userInfo);
        if(i == 0){
            request.setAttribute("errorMessage","修改密码失败");
            return "new_account/alterpass";
        }else{
            request.setAttribute("errorMessage","密码修改成功");
            getUserInfo().setPassword(newPassword);
            return "new_account/alterpass";
        }
    }
    @RequestMapping("/forget")
    public String forget() {
        return "new_account/forget";
    }

    @RequestMapping("/doforget")
    public String doforget(UserInfo userInfo, HttpSession session,HttpServletRequest request) {
        if(valideCheckcode(session,request) && valideUserName(session,request)){
            return "new_account/forget";
        }
        userInfo.setPassword(EncryptUtils.encryptMD5("123456"));
//        userInfo.setUserType(UserType.CUSTOM_USER);
        int i = userInfoService.updateUserPassword(userInfo);
        //TODO 发送密码”123456“ 给客户
        if(i == 0){
            request.setAttribute("errorMessage","发送失败");
            return "new_account/forget";
        }
        return "redirect:/login";
    }
    private boolean valiedeRegesterParam(HttpSession session,HttpServletRequest request){
        return valideTwoPassword(session,request) &&
                valideCheckcode(session,request) &&
                valideSmsCode(session,request) &&
                valideUserName(session,request);
    }
    private boolean valideUserName(HttpSession session,HttpServletRequest request){
        String userName = request.getParameter("userName");
        UserInfo userInfo = userInfoService.selectByUsername(userName);
        if(userInfo != null){
            request.setAttribute("errorMessage","用户已存在");
            return false;
        }
        return true;
    }
    private boolean valideTwoPassword(HttpSession session,HttpServletRequest request){
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if(password != null && password.length()>6){
            request.setAttribute("errorMessage","密码格式不正确");
            return false;
        }
        if(!password.equals(confirmPassword)){
            request.setAttribute("errorMessage","两次密码输入不一致");
            return false;
        }
        return true;
    }
    private boolean valideSmsCode(HttpSession session,HttpServletRequest request){
        String valideCode = request.getParameter("valideCode");
        if("a1bfc1".equals(valideCode)){
            return true;
        }
        request.setAttribute("errorMessage","短信验证码不正确");
        return false;
    }
    private boolean valideCheckcode(HttpSession session,HttpServletRequest request){
        String j_checkcode = request.getParameter("j_checkcode");
        Object seKeyMmCode = session.getAttribute("SE_KEY_MM_CODE");
        if(seKeyMmCode == null){
            return true;
        }
        if(seKeyMmCode.equals(j_checkcode)){
            return true;
        }
        request.setAttribute("errorMessage","验证码不正确");
        return false;
    }

    @RequestMapping("/index")
    @RequiresAuthentication
    public String index(){
        return "common/main";
    }

    @RequestMapping("/")
    public String welcome(){
        return "redirect:/index";
    }
}
