package com.lohas.service;

import com.lohas.dao.UserDAO;
import com.lohas.dao.UserInfoDAO;
import com.lohas.model.UserInfo;
import com.lohas.request.UserInfoRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.Status;
import com.lohas.view.UserInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Autowired
    private UserDAO userDAO;

        public UserInfoView getUserInfo(HttpServletRequest request){

           Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());

           UserInfoView userInfoView = new UserInfoView();

           UserInfo ui = userInfoDAO.getUserInfoByUser(userDAO.findUserByUserId(userId));

           if(ui!=null){
               userInfoView.setUserName(ui.getUserName());
               userInfoView.setPhoneNumber(ui.getPhoneNumber());
               userInfoView.setSex(ui.getSex());
               userInfoView.setAvatar(ui.getAvatar());
           }

           return userInfoView;
        }

        public Status updateUserInfo(UserInfoRequest userInfoRequest,HttpServletRequest request){

            Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());

            UserInfo ui = userInfoDAO.getUserInfoByUser(userDAO.findUserByUserId(userId));

            Status status = new Status();

            if(ui==null){
                status.setState(false);
                status.setMsg("用户不存在");
            }
            else{
                UserInfo userInfo = new UserInfo();
                userInfo.setUser(userDAO.findUserByUserId(userId));
                if(userInfoRequest.getUserName()!=null)userInfo.setUserName(userInfoRequest.getUserName());
                if(userInfoRequest.getSex()!=null)userInfo.setSex(userInfoRequest.getSex());
                if(userInfoRequest.getAvatar()!=null)userInfo.setAvatar(userInfoRequest.getAvatar());
                if(userInfoRequest.getPhoneNumber()!=null)userInfo.setPhoneNumber(userInfoRequest.getPhoneNumber());
                userInfoDAO.save(userInfo);
                status.setState(true);
                status.setMsg("修改个人信息成功");
            }
            return status;
        }
}
