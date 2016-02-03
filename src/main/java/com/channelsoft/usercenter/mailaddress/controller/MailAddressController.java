package com.channelsoft.usercenter.mailaddress.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.common.po.AjaxResultPo;
import com.channelsoft.usercenter.mailaddress.po.MailAddress;
import com.channelsoft.usercenter.mailaddress.service.IMailAddressService;


/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月5日</dd>
 * </dl>
 *
 * @author 肖迪
 */
@Controller
@RequestMapping("/mailAddress")
public class MailAddressController  extends BaseController {
    @Autowired
    private IMailAddressService mailAddressService;

    @RequiresAuthentication
    @RequestMapping("/gotoMailAddressList")
    public String gotoMailAddressList(HttpServletRequest request ,HttpServletResponse response) throws Exception{
        return "mailaddress/MailAddressListNew";
    }

    @RequiresAuthentication
    @RequestMapping("/queryMailAddressList")
    public String queryMailAddressList(MailAddress mailAddress ,HttpServletRequest request ,HttpServletResponse response) throws Exception {
//        logger.debug("进入寄送地址信息查询方法  MailAddressController.queryMailAddressList()");
        try {
            String enterpriseId = getUserInfo().getEnterpriseId().toString();
            mailAddress.setEnterpriseId(enterpriseId);
            List<MailAddress> list=mailAddressService.getMailAddress(mailAddress);
            request.setAttribute("list",list);
            return "mailaddress/MailAddressListNew";
        } catch (ServiceException e) {
            String msg = "查询寄送地址信息列表失败："+e.getMessage();
//            logger.error(msg,e);
            return "mailaddress/MailAddressListNew";
        }
    }

    @RequiresAuthentication
    @ResponseBody
    @RequestMapping("/addMailAddress")
    public AjaxResultPo addMailAddress(MailAddress mailAddress,HttpServletRequest request ) throws Exception{
//        logger.debug("进入寄送地址信息删除方法 MailAddressController.addMailAddress()");
        try {
//            String str=request.getParameter("aData");
//            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
//            Date date=new Date();
//            mailAddress.setCreateTime(date);
        	UserInfo userInfo = getUserInfo();
        	mailAddress.setEnterpriseId(userInfo.getEnterpriseId().toString());
            mailAddressService.addMailAsddress(mailAddress);
            return new AjaxResultPo(true, "添加寄送地址信息成功");
        } catch (ServiceException e) {
            String message = "添加寄送地址信息失败:" + e.getMessage();
//            logger.error(message,e);
            return new AjaxResultPo(false, message);
        }
    }

    @RequiresAuthentication
    @ResponseBody
    @RequestMapping("/updateMailAddress")
    public AjaxResultPo updateMailAddress(MailAddress mailAddress , HttpServletRequest request ,HttpServletResponse response) throws Exception{
//        logger.debug("进入寄送地址信息修改方法 MailAddressController.addMailAddress()");
        try {
            mailAddressService.updateMailAddress(mailAddress);
            return new AjaxResultPo(true, "修改寄送地址信息成功");
        } catch (ServiceException e) {
            String message = "修改寄送地址信息失败:" + e.getMessage();
//            logger.error(message,e);
            return new AjaxResultPo(false, message);
        }
    }

    @RequiresAuthentication
    @ResponseBody
    @RequestMapping("/deleteMailAddress")
    public AjaxResultPo deleteMailAddressList(MailAddress mailAddress ,HttpServletRequest request ,HttpServletResponse response) throws Exception{
//        logger.debug("进入寄送地址信息删除方法 MailAddressController.deleteMailAddressList()");
        try {
            mailAddressService.deleteMailAddress(mailAddress);
            return new AjaxResultPo(true,"删除寄送地址信息成功！");
        } catch (ServiceException e) {
            String message = "删除寄送地址信息失败：" + e.getMessage();
//            logger.error(message,e);
            return new AjaxResultPo(false, message);
        }
    }
}
