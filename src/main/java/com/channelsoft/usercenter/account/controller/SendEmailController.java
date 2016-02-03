package com.channelsoft.usercenter.account.controller;

import com.channelsoft.usercenter.account.po.Email;
import com.channelsoft.usercenter.account.po.EmailTemp;
import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.po.example.EmailTempExample;
import com.channelsoft.usercenter.account.po.example.EnterpriseInfoExample;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.account.service.ISendEmailService;
import com.channelsoft.usercenter.account.util.SendEmailUtil;
import com.channelsoft.usercenter.pay.util.MD5;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月18日</dd>
 * </dl>
 *
 * @author 肖迪
 */
@Controller
@RequestMapping("/sendEmail")
public class SendEmailController extends BaseController {
    @Autowired
    private ISendEmailService sendEmailService;

    @Value("${email.host}")
    private String host; // 服务器地址
    @Value("${email.sender}")
    private String sender; // 发件人的邮箱
    @Value("${email.name}")
    private String name; // 发件人昵称
    @Value("${email.username}")
    private String username; // 账号
    @Value("${email.password}")
    private String password; // 密码
    @Value("${email.subject}")
    private String subject; // 主题
    @Value("${email.message}")
    private String message; // 信息(支持HTML)
    @Value("${binding.url}")
    private String url;
    String receiver = "123";

    @RequiresAuthentication
    @RequestMapping("/gotoSendEmail")
    public String gotoSendEmail(HttpServletRequest request) throws Exception {
        String enterpriseId = getUserInfo().getEnterpriseId().toString();
        EmailTempExample emailTempExample = new EmailTempExample();
        emailTempExample.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
        List<EmailTemp> list = sendEmailService.queryEmailTemp(emailTempExample);
        if (null == list || list.size() == 0) {
            return "email/SendEmail";
        } else if (list.get(0).getBindingStatus() == 0) {
            return "email/SendSuccess";
        } else if (list.get(0).getBindingStatus() == 1) {
            EnterpriseInfoExample enterpriseExample = new EnterpriseInfoExample();
            enterpriseExample.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
            List<EnterpriseInfo> entList=sendEmailService.queryEmail(enterpriseExample);
            request.setAttribute("email", entList.get(0).getEmail());
            return "email/ChangeEmail";
        } else {
            return "email/SendEmail";
        }
    }

    @RequiresAuthentication
    @RequestMapping("/gotoSendEmailAgain")
    public String gotoSendEmailAgain(HttpServletRequest request) throws Exception {
        return "email/SendEmail";
    }

    @RequiresAuthentication
    @RequestMapping("/gotoUpdateEmail")
    public String gotoUpdateEmail(HttpServletRequest request) throws Exception {
        String enterpriseId = getUserInfo().getEnterpriseId().toString();
        EnterpriseInfoExample enterpriseExample = new EnterpriseInfoExample();
        enterpriseExample.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
        List<EnterpriseInfo> entList=sendEmailService.queryEmail(enterpriseExample);
        request.setAttribute("email", entList.get(0).getEmail());
        return "email/UpdateEmail";
    }

    @RequiresAuthentication
    @RequestMapping("/send")
    public String sendmail(HttpServletRequest request) throws Exception {
        logger.debug("进入发送邮件方法  SendEmailController.sendmail()");
        try {
            String enterpriseId = getUserInfo().getEnterpriseId().toString();
            EmailTempExample emailTempExample = new EmailTempExample();
            emailTempExample.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
            List<EmailTemp> list = sendEmailService.queryEmailTemp(emailTempExample);
            receiver = request.getParameter("receiver");
            //封装邮件发送对象
            Email email = new Email();
            email.setHost(host);
            email.setSender(sender);
            email.setReceiver(receiver);
            email.setName(name);
            email.setUsername(username);
            email.setPassword(password);
            email.setSubject(subject);
            String md5Key = MD5.sign(enterpriseId, host, null);
            email.setMessage("<a href='" + url+ "?mKey=" + md5Key + "'>点击" + url  + "完成注册</a>");
            //判断是首次绑定还是修改绑定
            if (null == list || list.size() == 0) {
                EmailTemp emailTemp = new EmailTemp();
//                emailTemp.setEnterpriseId(getUserInfo().getEnterpriseId());
                emailTemp.setEnterpriseId(Integer.parseInt(enterpriseId));
                emailTemp.setEmail(receiver);
                emailTemp.setBindingStatus((short) 0);
                emailTemp.setMd5Key(md5Key);
                sendEmailService.addEmailTemp(emailTemp);
            } else {
                EmailTemp emailTemp = new EmailTemp();
                emailTemp.setEmail(request.getParameter("receiver"));
                //修改邮箱临时表
                EmailTempExample emailTempExp = new EmailTempExample();
                emailTempExp.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
                sendEmailService.updateEmailTemp(emailTemp, emailTempExp);
            }
            //调用发送邮件方法
            SendEmailUtil s = new SendEmailUtil();
            s.send(email);
            logger.debug("发送邮件成功，离开发送邮件方法  SendEmailController.sendmail()");
            return "email/SendSuccess";
        } catch (ServiceException e) {
            String msg = "发送邮件失败：" + e.getMessage();
            logger.error(msg, e);
            return "email/SendEmail";
        }


    }

    @RequestMapping("/binding")
    public String binding(HttpServletRequest request) {
        logger.debug("进入绑定邮箱方法  SendEmailController.binding()");
        try {
            String sign = request.getParameter("mKey");
            EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
            //从临时表中查询出邮箱
            EmailTempExample entExample = new EmailTempExample();
            entExample.createCriteria().andMd5KeyEqualTo(sign);
            List<EmailTemp> list = sendEmailService.queryEmailTemp(entExample);
            if (null!=list&&list.size()!=0&&MD5.verify(list.get(0).getEnterpriseId().toString(), sign, host, null)) {
                enterpriseInfo.setEmail(list.get(0).getEmail());
                //向企业信息表中绑定邮箱
                EnterpriseInfoExample enterpriseExample = new EnterpriseInfoExample();
                enterpriseExample.createCriteria().andEnterpriseIdEqualTo(list.get(0).getEnterpriseId());
                sendEmailService.bindingEmail(enterpriseInfo, enterpriseExample);
                //修改邮箱临时表中状态
                EmailTemp emailTemp = new EmailTemp();
                emailTemp.setBindingStatus((short) 1);
                EmailTempExample emailTempExample = new EmailTempExample();
                emailTempExample.createCriteria().andEnterpriseIdEqualTo(list.get(0).getEnterpriseId());
                sendEmailService.updateEmailTemp(emailTemp, emailTempExample);
                return "email/BindingSuccess";
            } else {
                return "email/BindingFail";
            }

        } catch (ServiceException e) {
            String msg = "绑定邮箱失败：" + e.getMessage();
            logger.error(msg, e);
            return "email/SendEmail";
        }
    }


}