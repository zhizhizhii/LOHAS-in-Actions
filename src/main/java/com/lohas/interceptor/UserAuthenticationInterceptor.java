package com.lohas.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lohas.exception.AuthenticationException;
import com.lohas.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class UserAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");
        try {
            DecodedJWT decodedJWT = jwtUtils.getTokenInfo(token);
            //0_商家; 1_普通用户
            String role = decodedJWT.getClaim("role").asString();
            System.out.println("role = " +decodedJWT.getClaim("role").asString());
            if(!role.equals("1")){
                throw new AuthenticationException("无权限");
            }
            return true;
        }catch (AuthenticationException e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","您无权限访问！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","无效签名！");
        }
        map.put("state",false);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
