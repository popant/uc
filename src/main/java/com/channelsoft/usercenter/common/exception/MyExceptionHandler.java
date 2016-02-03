//package com.channelsoft.usercenter.common.exception;
//
//import java.io.IOException;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.shiro.authz.AuthorizationException;
//import org.apache.shiro.authz.UnauthorizedException;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.View;
//import org.springframework.web.servlet.view.RedirectView;
//
//public class MyExceptionHandler implements HandlerExceptionResolver {
//    private Log logger = LogFactory.getLog(this.getClass());
//    public ModelAndView resolveException( HttpServletRequest request, HttpServletResponse response,
//            Object handler, Exception exception ) {
//
//        logger.error("【抛出异常】--异常路径为：" +
//                request.getServletPath() + "\n【异常信息】--" + exception.getMessage()); ;
//        //如果不是抛出的action业务异常则不处理
//        if( exception instanceof AuthorizationException)  {
//            try {
//                return new ModelAndView("redirect:/login");
//                response.sendRedirect("showlogin");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else if(exception instanceof AuthorizationException) {
//            return ModuleAndView
//        }
//
//        final UnauthorizedException actionE = (UnauthorizedException) exception;
//        ModelAndView model = handleAuthorizationException();
//        if( actionE.getForwardType() == UnauthorizedException.FORWARD ) {
//                //进入页面渲染
//                model = new ModelAndView( actionE.getModelPath(), actionE.getAttributes());
//        } else if( actionE.getForwardType() == UnauthorizedException.REDIRECT ) {
//                model = new ModelAndView( new RedirectView( actionE.getModelPath(), true));
//        } else {
//            //直接返回页面内容
//            model = new ModelAndView( new View() {
//                @Override
//                public void render(Map<String, ?> arg0, HttpServletRequest arg1,
//                        HttpServletResponse arg2) throws Exception {
//
//                    arg2.setContentType( "text/html" );
//                    arg2.setCharacterEncoding( actionE.getEncode() );
//                    if( actionE.getResponseBody() != null ) {
//                        arg2.getWriter().print( actionE.getResponseBody() );
//                    }
//                }
//
//                @Override
//                public String getContentType() {
//                    return "text/html; charset=utf-8";
//                }
//            } );
//        }
//
//        return model;
//    }
//
//    private ModelAndView handleAuthorizationException() {
//        return null;
//    }
//}