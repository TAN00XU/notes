package com.tan00xu.config;

import com.tan00xu.utils.CmdOutputInformation;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TAN00XU
 * 登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        new CmdOutputInformation().info("经过了LoginHandlerInterceptor");
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            request.setAttribute("msg", "请登录后访问");
            response.sendRedirect(request.getContextPath() + "/");
//            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
