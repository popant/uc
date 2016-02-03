package com.channelsoft.usercenter.account.controller;

import com.channelsoft.usercenter.account.po.EnterpriseInfo;
import com.channelsoft.usercenter.account.po.status.AuditStatus;
import com.channelsoft.usercenter.account.service.IEnterpriseInfoService;
import com.channelsoft.usercenter.common.controller.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <dl>
 * <dd>Description:企业相关内容</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月19日</dd>
 * </dl>
 *
 * @author 安宁
 */
@Controller
@RequestMapping("/ent")
public class EnterprieseInfoController extends BaseController{
    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private IEnterpriseInfoService enterpriseInfoService;

    @RequiresAuthentication
    @RequestMapping("/authenticate")
    public String authenticate(HttpSession session,HttpServletRequest request) {
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.selectById(this.getUserInfo().getEnterpriseId());
        if(enterpriseInfo == null || enterpriseInfo.getAuditStatus() == null){
            request.setAttribute("errorMessage","企业不存在，请联系管理员。");
            return "error";
        }
        AuditStatus auditStatus = enterpriseInfo.getAuditStatus();
        if(AuditStatus.NOT_AUDIT == auditStatus){
            //进入为校验页面
//            return "new_ent/authenticate";
        }else if (AuditStatus.PASS_AUDIT == auditStatus){
            request.setAttribute("ent",enterpriseInfo);
//            return "new_ent/reauthenticate";
        }else {
            //进入校验中页面
            request.setAttribute("ent",enterpriseInfo);
//            return "new_ent/updateauthenticate";
        }
        return "new_ent/authenticate";
    }
    private String notAudit(HttpServletRequest request){
        return "new_ent/authenticate";
    }

    @RequiresAuthentication
    @RequestMapping("/doauthenticate")
    public String doauthenticate(@RequestParam(value = "businessLicenceFile") MultipartFile businessLicenceFile,EnterpriseInfo enterpriseInfo, HttpSession session,HttpServletRequest request) {
        EnterpriseInfo entDb = enterpriseInfoService.selectById(getUserInfo().getEnterpriseId());
        byte[] bytes = null;
        try {
            bytes = businessLicenceFile.getBytes();
            if(bytes.length == 0 && (entDb.getBusinessLicence() == null || entDb.getBusinessLicence().length == 0 )){
                request.setAttribute("errorMessage","上传文件失败，文件不能为空");
                return "new_ent/authenticate";
            }
        } catch (Exception e) {
            logger.error("上传文件失败,文件不能为空:" + e.getMessage(), e);
            request.setAttribute("errorMessage","上传文件失败："+e.getMessage());
            return "new_ent/authenticate";
        }
        AuditStatus auditStatus = enterpriseInfo.getAuditStatus();
        enterpriseInfo.setEnterpriseId(entDb.getEnterpriseId());
        if(auditStatus == null){
            //状态为null，说明是企业是初次更新。但是实际上是有问题的
            enterpriseInfo.setAuditStatus(AuditStatus.AUDITING);
        }else if(AuditStatus.FAIL_AUDIT == auditStatus || AuditStatus.PASS_AUDIT == auditStatus){
            //如果是认证失败，或者是认证成功，则修改状态为审核中。
            enterpriseInfo.setAuditStatus(AuditStatus.AUDITING);
        }
        if(bytes.length > 0){
            enterpriseInfo.setBusinessLicence(bytes);
        }
        int i = enterpriseInfoService.update(enterpriseInfo);
        if(i == 0){
            request.setAttribute("errorMessage","申请认证失败");
            return "redirect:/ent/authenticate";
        }
        return "redirect:/ent/authenticate";
    }
    @RequiresAuthentication
    @RequestMapping("/view")
    public String view(HttpSession session,HttpServletRequest request){
        Integer enterpriseId = getUserInfo().getEnterpriseId();
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.selectById(enterpriseId);
        request.setAttribute("enterpriseInfo",enterpriseInfo);
        return "new_ent/view";
    }
    @RequiresAuthentication
    @RequestMapping("/image")
    public String image(Integer enterpriseId,HttpServletResponse response){
        EnterpriseInfo enterpriseInfo = enterpriseInfoService.selectById(this.getUserInfo().getEnterpriseId());
        try {
            response.getOutputStream().write(enterpriseInfo.getBusinessLicence());
        } catch (IOException e) {
            logger.error("写图片失败",e);
        }
        return null;
    }
}
