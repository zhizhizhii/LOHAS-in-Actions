package com.lohas.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.Map;

@Configuration
@Component
public class JWTUtils {

    //token签名，根据配置文件注入
    @Value("${com.lohas.SIGNATURE}")
    private String SIGNATURE;

    /**
     * 签发Token
     *
     * @Author zhizhizhi
     * @Create 2021.4.1
     *
     * @param map 想要存储在payload字段中的信息
     *
     * @return Token 签发的Token
     */
    public String getToken(Map<String,String> map) {

        //定义token过期时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,3);//默认3天过期

        //使用JWT签发token
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGNATURE));
        return token;
    }

    /**
     * 验证Token
     *
     * @Author zhizhizhi
     * @Create 2021.4.1
     *
     * @param token 要验证的token信息
     *
     */
    public void verifyToken(String token) {
        JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    /**
     * 获取Token信息
     *
     * @Author zhizhizhi
     * @Create 2021.4.1
     *
     * @param token token值
     *
     * @return verify 获取解析后token对象
     */
    public DecodedJWT getTokenInfo(String token) {
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
