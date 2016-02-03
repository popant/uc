package com.channelsoft.usercenter.message.controller;

import com.alibaba.fastjson.JSONArray;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.message.mapper.MessageSecretKeyMapper;
import com.channelsoft.usercenter.message.po.MessageSecretKey;
import com.channelsoft.usercenter.message.po.MessageSecretKeyExample;
import com.channelsoft.usercenter.message.service.IMsgSecretkeyService;
import com.channelsoft.usercenter.message.util.HttpClientUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/msgSecretkey")
public class MsgSecretkeyController extends BaseController {
    @Autowired
    private IMsgSecretkeyService msgSecretkeyService;
    @Autowired
    private MessageSecretKeyMapper mapper;
    @Value("${msgSecretkey.url}")
    private String url;

    @RequiresAuthentication
    @RequestMapping("/queryMsgSecretkey")
    public String queryMsgSecretkey(HttpServletRequest request) throws Exception {
        logger.debug("进入查询密钥信息方法  MsgSecretkeyController.queryMsgSecretkey()");
        try {
            String enterpriseId = getUserInfo().getEnterpriseId().toString();
            MessageSecretKeyExample msgSkeyExample = new MessageSecretKeyExample();
            msgSkeyExample.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
            List<MessageSecretKey> list = msgSecretkeyService.getMessageSecretKey(msgSkeyExample);
            if(null!=list&&list.size()>0){
                request.setAttribute("apikey", list.get(0).getApiKey());
                request.setAttribute("secretkey", list.get(0).getSecretKey());
                //返回标示用区分重新申请还是提交申请
            }
            request.setAttribute("reqStatus", request.getParameter("reqStatus"));
        } catch (ServiceException e) {
            String msg = "查询短信密钥失败：" + e.getMessage();
            logger.error(msg, e);
        }
        return "message/MsgSecretkey";
    }

    @RequiresAuthentication
    @RequestMapping("/toApply")
    public String toApply(HttpServletRequest request) {
        logger.debug("进入申请密钥方法  MsgSecretkeyController.toApply()");
        try {
            String enterpriseId = getUserInfo().getEnterpriseId().toString();
//            int enterpriseId = 9090;
            MessageSecretKeyExample msgSkeyExample = new MessageSecretKeyExample();
            msgSkeyExample.createCriteria().andEnterpriseIdEqualTo(Integer.parseInt(enterpriseId));
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式

            MessageSecretKey msgSkey = new MessageSecretKey();
            msgSkey.setSecretKey(request.getParameter("secretkey"));
            msgSkey.setUpdateTime(df.parse(df.format(new Date())));
            msgSecretkeyService.addToApply(msgSkey, msgSkeyExample);
            //向http接口发送数据
            HttpClientUtil httpCUtil = new HttpClientUtil();
            Map<String, String> params = new HashMap<String, String>();
            //将变动数据整条发送个接口
            List<MessageSecretKey> list = msgSecretkeyService.getMessageSecretKey(msgSkeyExample);
            String jsonArray = JSONArray.toJSONString(list);
            params.put("jsonArray", jsonArray);
            String xml = httpCUtil.post(url, params);
            logger.info(xml);
            //返回标示用区分重新申请还是提交申请
            request.setAttribute("reqStatus", 1);
        } catch (ServiceException e) {
            String msg = "申请短信密钥异常：" + e.getMessage();
            logger.error(msg, e);
        } catch (Exception e) {
            String msg = "申请密钥后跳转查询页面异常：" + e.getMessage();
            logger.error(msg, e);
        }
        return "redirect:queryMsgSecretkey";
    }

}
