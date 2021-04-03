package com.lohas.service;

import com.lohas.config.WxInfoConfig;
import com.lohas.dao.UserDAO;
import com.lohas.model.User;
import com.lohas.request.LoginRequest;
import com.lohas.utils.HttpRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private WxInfoConfig wxInfoConfig;

    public LoginStatus logIn(LoginRequest body, HttpServletResponse response){

        LoginStatus loginStatus = new LoginStatus();

        try {
            String code = body.getCode();

            //定义参数
            String params = "appid=" + wxInfoConfig.getWXAPPID()
                    + "&secret=" + wxInfoConfig.getWXSECRET()
                    + "&js_code=" + code
                    + "&grant_type=" + wxInfoConfig.getWXGRANTTYPE();

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

                User user = userDAO.findUserByOpenId(openId);

                Map<String,String> payload = new HashMap<String,String>();
                //此时代表用户是第一次登录
                if(user==null){
                    loginStatus.setLogin_for_first(1);
                    //向数据库表中新建一条记录
                    User u = new User();
                    u.setOpenId(openId);
                    u.setRegisterTime(new Date());
                    userDAO.save(u);
                    payload.put("user_id",u.getUserId().toString());
                    payload.put("role","1");
                }
                else{
                    payload.put("user_id",user.getUserId().toString());
                    payload.put("role","1");
                    loginStatus.setLogin_for_first(0);
                }

                //token签发完成
                String token = JWTUtils.getToken(payload);

                loginStatus.setState(true);
                loginStatus.setMsg("登录成功！");

                //在header中设置token
                response.setHeader("token",token);

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
