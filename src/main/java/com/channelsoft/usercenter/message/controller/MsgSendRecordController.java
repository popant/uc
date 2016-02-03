package com.channelsoft.usercenter.message.controller;

import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.po.AjaxResultPo;
import com.channelsoft.usercenter.message.util.HttpClientUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月19日</dd>
 * </dl>
 *
 * @author 肖迪
 */
@Controller
@RequestMapping("/msgSend")
public class MsgSendRecordController extends BaseController {
    @Value("${msgSendRecord.url}")
    private String url;

    /**
     * 跳转到查询发送记录页面
     * @return
     * @throws Exception
     */
    @RequiresAuthentication
    @RequestMapping("/gotoMsgSendRecord")
    public String gotoMsgSendRecord() throws Exception {
        return "message/MsgSendRecord";
    }

    /**
     * 跳转到查询发送统计页面
     * @return
     * @throws Exception
     */
    @RequiresAuthentication
    @RequestMapping("/gotoMsgSendStatistics")
    public String gotoMsgSendStatistics() throws Exception {
        return "message/MsgSendStatics";
    }

    /**
     * 按条件查询发送记录
     *
     * @param request
     * @return
     */
    @RequiresAuthentication
    @ResponseBody
    @RequestMapping("/msgSendRecord")
    public AjaxResultPo msgSendRecord(HttpServletRequest request) {
        HttpClientUtil httpCUtil = new HttpClientUtil();
        Map<String, String> params = new HashMap<String, String>();
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String msgTemplateId = request.getParameter("msgTemplateId");
        if (StringUtils.hasText(startTime)) {
            params.put("startTime", startTime);
        }
        if (StringUtils.hasText(startTime)) {
            params.put("endTime", endTime);
        }
        if (StringUtils.hasText(startTime)) {
            params.put("msgTemplateId", msgTemplateId);
        }
        String result = httpCUtil.post(url, params);
        logger.info(result);
        return new AjaxResultPo(true, result);
    }

    /**
     * 按条件查询发送统计信息
     *
     * @param request
     * @return
     */
    @RequiresAuthentication
    @ResponseBody
    @RequestMapping("/msgSendStatistics")
    public AjaxResultPo msgSendStatistics(HttpServletRequest request) {
        HttpClientUtil httpCUtil = new HttpClientUtil();
        Map<String, String> params = new HashMap<String, String>();
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String msgTemplateId = request.getParameter("msgTemplateId");
        if (StringUtils.hasText(startTime)) {
            params.put("startTime", startTime);
        }
        if (StringUtils.hasText(startTime)) {
            params.put("endTime", endTime);
        }
        if (StringUtils.hasText(startTime)) {
            params.put("msgTemplateId", msgTemplateId);
        }
        String result = httpCUtil.post(url, params);
        logger.info(result);
        return new AjaxResultPo(true, result);
    }
}
