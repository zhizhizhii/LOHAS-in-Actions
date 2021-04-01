package com.lohas.service;

import com.lohas.request.LoginRequest;
import com.lohas.utils.HttpRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Configuration
@Component
public class UserService {

    @Value("${com.lohas.WXAPPID}")
    private String WXAPPID;
    @Value("${com.lohas.WXSECRET}")
    private String WXSECRET;
    @Value("${com.lohas.WXGRANTTYPE}")
    private String WXGRANTTYPE;

    @Autowired
    JWTUtils jwtUtils;

    public LoginStatus logIn(LoginRequest body){

        LoginStatus loginStatus = new LoginStatus();

        try {
            String code = body.getCode();

            //定义参数
            String params = "appid=" + WXAPPID
                    + "&secret=" + WXSECRET
                    + "&js_code=" + code
                    + "&grant_type=" + WXGRANTTYPE;

            //向wechat服务器发送https请求
            String result = HttpRequest.sendGet(
                    "https://api.weixin.qq.com/sns/jscode2session",
                    params);

            JSONObject jsonObj = new JSONObject(result);

            if (jsonObj.has("errcode")) {
                throw new Exception();
            }
            else {
                String openId = jsonObj.getString("openid");

                Map<String,String> payload = new HashMap<String,String>();

                payload.put("openid",openId);

                //token签发完成
                String token = jwtUtils.getToken(payload);
                loginStatus.setState(true);
                loginStatus.setMsg("登录成功！");
                loginStatus.setToken(token);
                return loginStatus;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        loginStatus.setState(false);
        loginStatus.setMsg("登录失败！");
        return loginStatus;
    }
}
