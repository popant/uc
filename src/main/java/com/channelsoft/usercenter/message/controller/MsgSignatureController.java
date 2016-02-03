package com.channelsoft.usercenter.message.controller;

import com.alibaba.fastjson.JSONArray;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.po.MessageSecretKey;
import com.channelsoft.usercenter.message.po.MessageSecretKeyExample;
import com.channelsoft.usercenter.message.po.MessageSignatureInfo;
import com.channelsoft.usercenter.message.po.MessageSignatureInfoExample;
import com.channelsoft.usercenter.message.service.IMsgSignatureService;
import com.channelsoft.usercenter.message.util.HttpClientUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月13日</dd>
 * </dl>
 *
 * @author 肖迪
 */
@Controller
@RequestMapping("/msgSignature")
public class MsgSignatureController extends BaseController {
    @Autowired
    private IMsgSignatureService msgSignatureService;
    @Value("${msgSignature.url}")
    private String url;

    @RequiresAuthentication
    @RequestMapping("/gotoMsgmenu")
    public String gotoMsgmenu() throws Exception {
        logger.debug("进入跳转二级菜单方法  MsgSignatureController.gotoMsgmenu()");
        return "message/left";
    }

    @RequiresAuthentication
    @RequestMapping("/queryMsgSignature")
    public String queryMsgSignature(HttpServletRequest request) throws Exception {
        logger.debug("进入短信签名信息查询方法  MsgSignatureController.queryMsgSignature()");
        try {
            String enterpriseId=getUserInfo().getEnterpriseId().toString();
            MessageSignatureInfoExample MsgSignatureExp=new MessageSignatureInfoExample();
            MsgSignatureExp.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
            List<MessageSignatureInfo> list = msgSignatureService.getMsgSignature(MsgSignatureExp);
            if (null != list&&list.size()!=0) {
//                msgSignatureService.updateMsgSignature(msgSignature);
//                msgSig = msgSignatureService.getMsgSignature(msgSignature);
                request.setAttribute("msgSignatureInfo", list.get(0).getMessageSignature());
                request.setAttribute("auditStatus", list.get(0).getAuditStatus());
                request.setAttribute("msgSignatureId", list.get(0).getMsgsignatureId());
                request.setAttribute("enterpriseId", list.get(0).getEnterpriseId());
                request.setAttribute("auditInfo", list.get(0).getAuditInfo());
            }
            return "message/MsgSignature";
        } catch (Exception e) {
            String msg = "查询短信签名失败：" + e.getMessage();
            logger.error(msg, e);
            return "message/500";
        } 
    }

    @RequiresAuthentication
    @RequestMapping("/toAudit")
    public String toAudit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("进入提交短信签名审核方法 MailAddressController.addMailAddress()");
        try {
            String enterpriseId=getUserInfo().getEnterpriseId().toString();
            MessageSignatureInfo msgSignature = new MessageSignatureInfo();
            //查询短信签名信息
            MessageSignatureInfoExample MsgSignatureExp=new MessageSignatureInfoExample();
            MsgSignatureExp.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
            List<MessageSignatureInfo> list=msgSignatureService.getMsgSignature(MsgSignatureExp);
            if(null==list||list.size()==0){
                msgSignature.setMessageSignature(new String(request.getParameter("msgSignatureInfo").getBytes("iso-8859-1"),"utf-8"));
                msgSignature.setEnterpriseId(Integer.parseInt(enterpriseId));
                msgSignature.setAuditStatus((short)2);
                msgSignatureService.auditMsgSignature(msgSignature);
            }else if(list.size()!=0){
                msgSignature.setMessageSignature(new String(request.getParameter("msgSignatureInfo").getBytes("iso-8859-1"),"utf-8"));
                msgSignature.setEnterpriseId(Integer.parseInt(enterpriseId));
                msgSignature.setAuditStatus((short)2);
                msgSignatureService.auditMsgSignatureAgain(msgSignature,MsgSignatureExp);
            }
            //查询修改后的短信签名
            List<MessageSignatureInfo> msgList=msgSignatureService.getMsgSignature(MsgSignatureExp);
            HttpClientUtil httpCUtil = new HttpClientUtil();
            Map<String, String> params = new HashMap<String, String>();
            //将变动数据整条发送个接口
            String jsonArray = JSONArray.toJSONString(msgList.get(0));
            params.put("jsonArray", jsonArray);
            String xml = httpCUtil.post(url, params);
            logger.info(xml);
            return "redirect:queryMsgSignature";
        } catch (ServiceException e) {
            String message = "提交短信签名审核失败:" + e.getMessage();
            logger.error(message, e);
            return "redirect:queryMsgSignature";
        }
    }

}
