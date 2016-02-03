package com.channelsoft.usercenter.common.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <dl>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年01月27日</dd>
 * </dl>
 *
 * @author 安宁
 */
public class MenuFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String currentParentId = request.getParameter("currentParentId");
        String currentMenuId = request.getParameter("currentMenuId");
        if(currentMenuId != null && !currentMenuId.trim().isEmpty()){
            request.getSession().setAttribute("currentMenuId" , currentMenuId);
        }
        if(currentParentId != null && !currentParentId.trim().isEmpty()){
            request.getSession().setAttribute("currentParentId" , currentParentId);
        }
        filterChain.doFilter(request,response);
    }
}
