package com.gujiu21l.tp.filters;

import com.gujiu21l.tp.common.Result;
import com.gujiu21l.tp.common.ResultCodeEnum;
import com.gujiu21l.tp.util.JwtHelper;
import com.gujiu21l.tp.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 孤酒21L
 * @description TODO
 * @date 2024-04-22 21:11
 */

@WebFilter("/headline/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");

        boolean flag = false;

        if (token != null) {
            if (!JwtHelper.isExpiration(token)) {
                flag = true;
            }
        }

        if (flag == true) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
            WebUtil.writeJson(response, result);
        }
    }

}
