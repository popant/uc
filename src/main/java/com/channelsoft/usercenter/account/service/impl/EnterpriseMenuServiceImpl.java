package com.channelsoft.usercenter.account.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.channelsoft.usercenter.business.po.status.ProductStatus;
import com.channelsoft.usercenter.consumable.mapper.EnterpriseProductRelaMapper;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRela;
import com.channelsoft.usercenter.consumable.po.EnterpriseProductRelaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.channelsoft.usercenter.account.mapper.EnterpriseMenuMapper;
import com.channelsoft.usercenter.account.mapper.RoleMenuRelaMapper;
import com.channelsoft.usercenter.account.mapper.UserRoleRelaMapper;
import com.channelsoft.usercenter.account.po.EnterpriseMenu;
import com.channelsoft.usercenter.account.po.RoleMenuRela;
import com.channelsoft.usercenter.account.po.UserRoleRela;
import com.channelsoft.usercenter.account.po.example.EnterpriseMenuExample;
import com.channelsoft.usercenter.account.po.example.RoleMenuRelaExample;
import com.channelsoft.usercenter.account.po.example.UserRoleRelaExample;
import com.channelsoft.usercenter.account.service.IEnterpriseMenuService;
import com.channelsoft.usercenter.common.mapper.IGenericMapper;
import com.channelsoft.usercenter.common.service.impl.GenericServiceImpl;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月12日</dd>
 * </dl>
 *
 * @author 安宁
 */
@Service
public class EnterpriseMenuServiceImpl extends GenericServiceImpl<EnterpriseMenu,Integer> implements IEnterpriseMenuService{
    @Autowired
    private EnterpriseMenuMapper mapper;
    @Autowired
    private UserRoleRelaMapper userRoleRelaMapper;
    @Autowired
    private RoleMenuRelaMapper roleMenuRelaMapper;
    @Autowired
    private EnterpriseProductRelaMapper enterpriseProductRelaMapper;
    private static Map<Short, Integer> productMenuRelaMap;
    @Override
    public IGenericMapper<EnterpriseMenu, Integer> getMapper() {
        return mapper;
    }
    static{
        short a = 1;
        short b = 2;
        short c = 3;
        productMenuRelaMap = new HashMap<Short, Integer>();
        productMenuRelaMap.put(a,5);
        productMenuRelaMap.put(b,24);
        productMenuRelaMap.put(c,23);
    }

    @Override
    public String getJsonMenuList(Integer userId, Integer enterpriseId) {
        UserRoleRelaExample userRoleRelaExample = new UserRoleRelaExample();
        userRoleRelaExample.createCriteria().andUserIdEqualTo(userId);
        List<UserRoleRela> userRoleRelas = userRoleRelaMapper.selectByExample(userRoleRelaExample);
        List<Integer> roleIdList = new ArrayList<Integer>();
        //获取roleId的列表
        if(userRoleRelas != null && !userRoleRelas.isEmpty()){
            for (UserRoleRela userRoleRela : userRoleRelas) {
                Integer roleId = userRoleRela.getRoleId();
                roleIdList.add(roleId);
            }
        }
        //获取menuId列表
        List<Integer> menuIdList = new ArrayList<Integer>();
        if(roleIdList != null && !roleIdList.isEmpty()){
            RoleMenuRelaExample roleMenuRelaExample = new RoleMenuRelaExample();
            roleMenuRelaExample.createCriteria().andRoleIdIn(roleIdList);
            List<RoleMenuRela> roleMenuRelas = roleMenuRelaMapper.selectByExample(roleMenuRelaExample);
            for (RoleMenuRela roleMenuRela : roleMenuRelas) {
                menuIdList.add(roleMenuRela.getMenuId());
            }
        }
        //获取额外menuId列表
        List<Integer> otherMenuIdList = getOtherMenuId(enterpriseId);
        if(otherMenuIdList != null ){
            menuIdList.addAll(otherMenuIdList);
        }
        //根据menuId列表得到菜单的json数据
        if(menuIdList != null && !menuIdList.isEmpty()){
            EnterpriseMenuExample example = new EnterpriseMenuExample();
            example.createCriteria().andMenuIdIn(menuIdList);
            List<EnterpriseMenu> enterpriseMenus = mapper.selectByExample(example);
            return handleMenuToJson(enterpriseMenus);
        }
        return "[]";
    }

    /**
     * @param enterpriseId
     * 获取一些额外的菜单。开通后才会有这些菜单。
     */
    private List<Integer> getOtherMenuId(Integer enterpriseId) {
        EnterpriseProductRelaExample example = new EnterpriseProductRelaExample();
        example.createCriteria().andEnterpriseIdEqualTo(String.valueOf(enterpriseId));
        List<EnterpriseProductRela> enterpriseProductRelas = enterpriseProductRelaMapper.selectByExample(example);
        List<Integer> otherMenuId = new ArrayList<Integer>();
        if(enterpriseProductRelas != null && !enterpriseProductRelas.isEmpty()){
            for (EnterpriseProductRela enterpriseProductRela : enterpriseProductRelas) {
                Short productId = enterpriseProductRela.getProductId();
                otherMenuId.add(productMenuRelaMap.get(productId));
            }
        }
        return otherMenuId;
    }

    /**
     * 将一批无序列的menu转化成菜单Json,并排序
     * @param menuList
     * @return
     */
    private String handleMenuToJson(List<EnterpriseMenu> menuList){
        JSONArray resultArray = new JSONArray();
        if(menuList != null && !menuList.isEmpty()){
            Map<Integer,EnterpriseMenu> idMap = new HashMap<Integer,EnterpriseMenu>();
            Map<Integer,List<EnterpriseMenu>> menuMap = new HashMap<Integer,List<EnterpriseMenu>>();
            for (EnterpriseMenu em : menuList) {
                Integer menuId = em.getMenuId();
                Integer parentId = em.getParentId();
                if(parentId == 0){
                    List<EnterpriseMenu> enterpriseMenus = menuMap.get(menuId);
                    if(enterpriseMenus == null ){
                        enterpriseMenus = new ArrayList<EnterpriseMenu>();
                        menuMap.put(menuId,enterpriseMenus);
                    }
                    idMap.put(menuId , em);
                }else{
                    List<EnterpriseMenu> enterpriseMenus = menuMap.get(parentId);
                    if(enterpriseMenus == null ){
                        enterpriseMenus = new ArrayList<EnterpriseMenu>();
                        menuMap.put(parentId,enterpriseMenus);
                    }
                    enterpriseMenus.add(em);
                }
            }
            for (Integer pid : menuMap.keySet()) {
                EnterpriseMenu pem = idMap.get(pid);
                if(pem == null){
                    continue;
                }
                JSONObject pjson = (JSONObject)JSONObject.toJSON(pem);
                List<EnterpriseMenu> subMenuList = menuMap.get(pid);
                Collections.sort(subMenuList, new Comparator<EnterpriseMenu>() {
                    @Override
                    public int compare(EnterpriseMenu o1, EnterpriseMenu o2) {
                        return o1.getMenuOrder() - o2.getMenuOrder();
                    }
                });
                pjson.put("subMenuList",JSONArray.toJSON(subMenuList));
                resultArray.add(pjson);
            }
        }
        return resultArray.toJSONString();
    }
}
