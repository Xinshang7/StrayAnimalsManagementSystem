package com.HexTechGDUT.security;

import com.HexTechGDUT.service.TokenService;
import com.HexTechGDUT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author HexTechGDUT
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             @Nullable HttpServletResponse httpServletResponse,
                             @Nullable Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(AuthToken.class)) {
            AuthToken authToken = method.getAnnotation(AuthToken.class);
            if (authToken.required()) {
                if (token == null) {
                    throw new RuntimeException("无token，请登录");
                }
                //验证token
                tokenService.verify(token);
                //验证token中的登录用户id是否存在
            }
        }
        return true;
    }

    @Override
    public void postHandle(@Nullable HttpServletRequest httpServletRequest,
                           @Nullable HttpServletResponse httpServletResponse,
                           @Nullable Object o, ModelAndView modelAndView) {
    }
    @Override
    public void afterCompletion(@Nullable HttpServletRequest httpServletRequest,
                                @Nullable HttpServletResponse httpServletResponse,
                                @Nullable Object o, Exception e) {
    }
}
