/**
 * 
 */
package com.channelsoft.usercenter.invoice.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.channelsoft.usercenter.account.po.UserInfo;
import com.channelsoft.usercenter.common.controller.BaseController;
import com.channelsoft.usercenter.common.exception.ServiceException;
import com.channelsoft.usercenter.consumable.service.IConsumeService;
import com.channelsoft.usercenter.invoice.po.InvoiceInfo;
import com.channelsoft.usercenter.invoice.po.InvoiceRecord;
import com.channelsoft.usercenter.invoice.po.status.InvoiceAuditStatus;
import com.channelsoft.usercenter.invoice.po.status.InvoiceKindType;
import com.channelsoft.usercenter.invoice.po.status.InvoiceMailStatus;
import com.channelsoft.usercenter.invoice.po.status.InvoiceType;
import com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceKindTypeEditor;
import com.channelsoft.usercenter.invoice.po.typeHandler.InvoiceTypeEditor;
import com.channelsoft.usercenter.invoice.service.IInvoiceInfoService;
import com.channelsoft.usercenter.invoice.service.IInvoiceRecordService;
import com.channelsoft.usercenter.mailaddress.po.MailAddress;
import com.channelsoft.usercenter.mailaddress.service.IMailAddressService;

/**
 * <dl>
 * <dt>InvoiceController</dt>
 * <dd>Description:发票controller类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年1月16日</dd>
 * </dl>
 * 
 * @author cy
 */
@Controller
@RequestMapping(value="/invoice")
public class InvoiceController extends BaseController {
	@Autowired
	private IInvoiceInfoService invoiceInfoService;
	@Autowired
	private IInvoiceRecordService invoiceRecordService;
	@Autowired
	private IConsumeService consumeService;
	@Autowired
	private IMailAddressService mailAddressService;
	
	/**
	 * 发票索取
	 * @param model
	 * @return
	 */
	@RequiresAuthentication
	@RequestMapping(value="/get")
	public String gotoInvoiceGet(Model model){
		boolean canEdit = true;
		InvoiceInfo invoiceInfo = null;
		try {
			//计算消费记录中的总消费额记录
			UserInfo userInfo = getUserInfo();
			BigDecimal sumConsume = consumeService.getSumConsumableOrders(userInfo.getEnterpriseId());
			//查询已开发票金额
			BigDecimal sumInvoiceRecord = invoiceRecordService.getSumInvoiceMoneyStatics(userInfo.getEnterpriseId());
			//差额为可开发票金额
			BigDecimal maxInvoiceNum = (sumConsume!=null?sumConsume:new BigDecimal(0)).subtract(sumInvoiceRecord!=null?sumInvoiceRecord:new BigDecimal(0));
			model.addAttribute("maxInvoiceNum", maxInvoiceNum);
			
			//查询当前企业的发票邮寄地址
			MailAddress exp = new MailAddress();
			exp.setEnterpriseId(userInfo.getEnterpriseId().toString());
			List<MailAddress> addressList = mailAddressService.getMailAddress(exp);
			logger.debug("当前企业发票的邮寄地址为:"+addressList);
			model.addAttribute("addressList", addressList);
			//取当前企业设置的发票信息(审核通过的)
			invoiceInfo = invoiceInfoService.getPassAuditInvoiceInfo(userInfo.getEnterpriseId());
			if(invoiceInfo==null){
				//没有配置发票信息页面不能操作
				canEdit = false;
			}
		} catch (ServiceException e) {
			logger.error(e);
			//页面出错禁止编辑
			canEdit = false;
		} catch (Exception e) {
			logger.error(e);
			canEdit = false;
		}
		model.addAttribute("canEdit", canEdit);
		model.addAttribute("invoiceInfo", invoiceInfo);
		return "new_invoice/invoiceGet";
	}
	
	/**
	 * 发票信息管理
	 * @param model
	 * @return
	 */
	@RequiresAuthentication
	@RequestMapping(value="/control")
	public String gotoInvoiceControl(Model model){
		UserInfo userInfo = getUserInfo();
		InvoiceInfo invoiceInfo = invoiceInfoService.getInvoiceInfoWithBlob(userInfo.getEnterpriseId());
		model.addAttribute("invoiceInfo", invoiceInfo);
		boolean canEdit = false;
		if(invoiceInfo==null){
			canEdit = true;
		}else if(invoiceInfo.getAuditStatus()!=null&&invoiceInfo.getAuditStatus().getValue()==InvoiceAuditStatus.FAIL_AUDIT.getValue()){
			canEdit = true;
			model.addAttribute("failCause", invoiceInfo.getAuditInfo());
		}
		model.addAttribute("canEdit", canEdit);
		return "new_invoice/invoiceControl";
	}
	
	@RequiresAuthentication
	@RequestMapping(value="/saveInfo",method=RequestMethod.POST)
	public String saveInvoiceInfo(InvoiceInfo invoiceInfo,RedirectAttributes redirectAttributes){
		try {
			logger.debug("进入InvoiceController.saveInvoiceInfo()");
			UserInfo userInfo = getUserInfo();
			invoiceInfo.setEnterpriseId(userInfo.getEnterpriseId().toString());
			if(invoiceInfo.getInvoiceKind().getValue()==InvoiceKindType.PERSONAL.getValue()){
				invoiceInfo.setAuditStatus(InvoiceAuditStatus.PASS_AUDIT);
			}else{
				invoiceInfo.setAuditStatus(InvoiceAuditStatus.AUDITING);
			}
			invoiceInfoService.saveInvoiceInfo(invoiceInfo);
		} catch (Exception e) {
			logger.error(e);
			redirectAttributes.addFlashAttribute("err", "保存信息失败");
		}
		return "redirect:control";
	}
	
	/**
	 * 保存索取发票信息
	 * @param addressId
	 * @param invoiceSum
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresAuthentication
	@RequestMapping(value="/saveRecord",method=RequestMethod.POST)
	public String saveInvoiceRecord(@RequestParam("addressId")String addressId, @RequestParam("invoiceSum")String invoiceSum,RedirectAttributes redirectAttributes){
		try {
			logger.debug("进入InvoiceController.saveInvoiceRecord()");
			UserInfo userInfo = getUserInfo();
			//发票信息
			InvoiceInfo invoiceInfo = invoiceInfoService.getPassAuditInvoiceInfo(userInfo.getEnterpriseId());
			InvoiceRecord invoiceRecord = new InvoiceRecord();
			//邮件地址
			MailAddress mailAddress = new MailAddress();
			mailAddress.setId(Integer.parseInt(addressId));
			List<MailAddress> mailAddressList = mailAddressService.getMailAddress(mailAddress);
			invoiceRecord.setAddress(mailAddressList.get(0).getMailAddress());
			invoiceRecord.setEnterpriseId(userInfo.getEnterpriseId().toString());
			invoiceRecord.setInvoiceId(invoiceInfo.getInvoiceId());
			invoiceRecord.setInvoiceMoney(new BigDecimal(invoiceSum));
			invoiceRecord.setPhoneNumber(mailAddressList.get(0).getPhoneNumber());
			invoiceRecord.setPostalCode(mailAddressList.get(0).getPostalCode());
			invoiceRecord.setName(mailAddressList.get(0).getMailName());
			invoiceRecord.setInvoiceStatus(InvoiceMailStatus.NOT_MAIL);
			invoiceRecordService.saveInvoiceRecord(invoiceRecord);
			redirectAttributes.addFlashAttribute("msg", "索取发票成功!");
		} catch (NumberFormatException e) {
			logger.error(e);
			redirectAttributes.addFlashAttribute("err", "索取发票失败");
		} catch (ServiceException e) {
			logger.error(e);
			redirectAttributes.addFlashAttribute("err", "索取发票失败");
		}
		return "redirect:get";
	}
	
	/**
	 * 发票预览
	 * @param type
	 * @return
	 * @throws IOException
	 */
	@RequiresAuthentication
	@RequestMapping(value="/preview/{type}")  
    public ResponseEntity<byte[]> downLoadDoc(@PathVariable("type")String type) throws IOException {  
    	UserInfo userInfo = getUserInfo();
		InvoiceInfo invoiceInfo = invoiceInfoService.getInvoiceInfoWithBlob(userInfo.getEnterpriseId());
		HttpHeaders headers = new HttpHeaders();  
    	headers.setContentType(MediaType.IMAGE_JPEG);    
//        headers.setContentDispositionFormData("attachment", "test.jpg");  
    	if(invoiceInfo==null){
    		return new ResponseEntity<byte[]>(draw(),headers, HttpStatus.OK);
    	}
        byte[] img = null;
        if(type.equals("b")){
        	img = invoiceInfo.getBusinessLicence();
        }else if(type.equals("t")){
        	img = invoiceInfo.getTaxRegistration();
        }else if(type.equals("g")){
        	img = invoiceInfo.getGeneralTaxQua();
        }
        if(img==null){
    		return new ResponseEntity<byte[]>(draw(),headers, HttpStatus.OK);
    	}else{
    		return new ResponseEntity<byte[]>(img,headers, HttpStatus.OK);    
    	}
    }  
    
    private byte[] draw() throws IOException{
    	int width = 200;   
        int height = 150;   
        String s = "请选择上传图片";   
           
        Font font = new Font("Serif", Font.BOLD, 10);   
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
        Graphics2D g2 = (Graphics2D)bi.getGraphics();   
        g2.setBackground(Color.WHITE);   
        g2.clearRect(0, 0, width, height);   
        g2.setPaint(Color.GRAY);   
           
        FontRenderContext context = g2.getFontRenderContext();   
        Rectangle2D bounds = font.getStringBounds(s, context);   
        double x = (width - bounds.getWidth()) / 2;   
        double y = (height - bounds.getHeight()) / 2;   
        double ascent = -bounds.getY();   
        double baseY = y + ascent;   
           
        g2.drawString(s, (int)x, (int)baseY);   
        ByteArrayOutputStream bao=new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", bao);
        return bao.toByteArray();
    }
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(InvoiceKindType.class, "invoiceKind", new InvoiceKindTypeEditor());
		binder.registerCustomEditor(InvoiceType.class, "invoiceType", new InvoiceTypeEditor());
	}
	
}