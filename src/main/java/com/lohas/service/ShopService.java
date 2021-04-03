package com.lohas.service;

import com.lohas.dao.ShopDAO;
import com.lohas.exception.UsernameExistExcepetion;
import com.lohas.model.Shop;
import com.lohas.model.User;
import com.lohas.request.ShopRequest;
import com.lohas.utils.HashHelper;
import com.lohas.utils.JWTUtils;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ShopService {

    @Autowired
    ShopDAO shopDAO;

    public Status register(ShopRequest shopRequest){
        Status status = new Status();
        try{
            Shop shop = shopDAO.findShopByUsername(shopRequest.getUsername());
            if(shop!=null) throw new UsernameExistExcepetion();

            Shop s = new Shop();
            s.setUsername(shopRequest.getUsername());

            double seed = ThreadLocalRandom.current().nextDouble();
            s.setSalt(HashHelper.computeSha256Hash(s.getUsername() + seed));
            s.setPassword(HashHelper.computeSha256Hash(shopRequest.getPassword()+s.getSalt()));
            s.setRegisterTime(new Date());
            shopDAO.save(s);

            status.setState(true);
            status.setMsg("注册成功");
            return status;
        }catch (UsernameExistExcepetion e){
            e.printStackTrace();
            status.setState(false);
            status.setMsg("注册失败");
            return status;
        }
    }

    public Status login(ShopRequest shopRequest, HttpServletResponse response){
        Status status = new Status();
        try{
            Shop shop = shopDAO.findShopByUsername(shopRequest.getUsername());
            if(shop == null) throw new Exception();

            String passwordHashed= HashHelper.computeSha256Hash(shopRequest.getPassword() + shop.getSalt());
            if(!shop.getPassword().equals(passwordHashed)) throw new Exception();

            //此时验证通过，签发商家Token
            Map<String,String> payload = new HashMap<String,String>();
            payload.put("shop_id",shop.getShopId().toString());
            payload.put("role","0");
            String token = JWTUtils.getToken(payload);
            response.setHeader("token",token);
            status.setState(true);
            status.setMsg("登录成功");
            return status;
        }catch (Exception e){
            e.printStackTrace();
            status.setState(false);
            status.setMsg("账号/密码错误，登录失败");
            return status;
        }
    }
}
