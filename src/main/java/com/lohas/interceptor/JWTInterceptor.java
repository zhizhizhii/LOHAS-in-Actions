package com.lohas.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lohas.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();

        String token = request.getHeader("token");

        try {
            jwtUtils.verifyToken(token);
            return true;
        }catch (SignatureVerificationException e){
            e.printStackTrace();

            map.put("msg","无效签名！");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","token已过期！");
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","token算法不一致！");
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
