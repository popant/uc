package com.channelsoft.usercenter.message.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.HandlerException;
import com.channelsoft.usercenter.message.mapper.MessageTemplateInfoMapper;
import com.channelsoft.usercenter.message.po.MessageTemplateInfo;
import com.channelsoft.usercenter.message.po.MessageTemplateInfoExample;
import com.channelsoft.usercenter.message.service.IMsgTemplateService;


/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月20日</dd>
 * </dl>
 *
 * @author 肖迪
 */
@Controller
@RequestMapping("/msgtemplate")
public class MsgTemplateController extends BaseController {
    @Autowired
    private IMsgTemplateService msgSignatureService;
    @Autowired
    private MessageTemplateInfoMapper mapper;

    @RequiresAuthentication
    @RequestMapping("/goto")
    public String gotoMsgtemplate() {
        return "message/MsgTemplateList";
    }

    @RequiresAuthentication
    @RequestMapping("/list")
    public String querMsgtemplate(HttpServletRequest request) {
        logger.info("进入查询短信模板方法 MsgTemplateController.querMsgtemplate()");
        try {
            //获取
//            msgSignature.setEnterpriseId(getUserInfo().getEnterpriseId().toString());
            //封装查询条件
            MessageTemplateInfoExample msgTemplateExample = new MessageTemplateInfoExample();
            String enterpriseId=getUserInfo().getEnterpriseId().toString();
            msgTemplateExample.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
            //查询该企业所有短信模板
            List<MessageTemplateInfo> list = msgSignatureService.getMsgTemplate(msgTemplateExample);
            request.setAttribute("list", list);
//            JSONObject ret = new JSONObject();
//            ret.put("list", list);
//            ret.put("ret", "0");
//            logger.debug("当前企业短信模板列表为:" + ret.toJSONString());
//            return JSON.toJSONString(ret, SerializerFeature.DisableCircularReferenceDetect);
            return "message/MsgTemplateList";
        } catch (HandlerException e) {
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
//        JSONObject ret = new JSONObject();
//        ret.put("ret", "-1");
//        logger.debug("查询短信模板数据异常");
//        return ret.toString();
        return "message/MsgTemplateList";
    }

    /**
     * 新建短信模板
     *
     * @param msgTemplate
     */
    @RequiresAuthentication
    @RequestMapping("/add")
    public void addMsgtemplate(MessageTemplateInfo msgTemplate) {
        logger.info("进入添加短信模板方法 MsgTemplateController.deleteMsgtemplate()");
        try {
            msgSignatureService.addMsgTemplate(msgTemplate);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 短信模板提交审核
     *
     * @param msgTemplate
     */
    @RequiresAuthentication
    @RequestMapping("/toAudit")
    public void toAudit(MessageTemplateInfo msgTemplate) {
        logger.info("进入添加短信模板方法 MsgTemplateController.deleteMsgtemplate()");
        try {
            msgSignatureService.addMsgTemplate(msgTemplate);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 删除短信模板
     */
    @RequiresAuthentication
    @RequestMapping("/delte")
    public void deleteMsgtemplate() {
        logger.info("进入短信模板删除方法 MsgTemplateController.deleteMsgtemplate()");
        try {
            String enterpriseId=getUserInfo().getEnterpriseId().toString();
            MessageTemplateInfoExample msgTemplateExample = new MessageTemplateInfoExample();
            msgTemplateExample.createCriteria().andMsgtemplateIdEqualTo(Integer.parseInt(enterpriseId));
            msgSignatureService.deleteMsgTemplate(msgTemplateExample);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}
