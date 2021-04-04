package com.lohas.service;

import com.lohas.dao.ShopDAO;
import com.lohas.dao.UserCollectDAO;
import com.lohas.dao.UserDAO;
import com.lohas.model.Shop;
import com.lohas.model.User;
import com.lohas.model.UserCollect;
import com.lohas.request.CreateCollectionRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
public class CollectionService {

    @Autowired
    UserCollectDAO userCollectDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    ShopDAO shopDAO;

    public Status createCollection(CreateCollectionRequest createCollectionRequest, HttpServletRequest request){
        Status status = new Status();
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        try{
            User user = userDAO.findUserByUserId(userId);
            Shop shop = shopDAO.findShopByShopId(createCollectionRequest.getShopId());
            UserCollect userCollect = new UserCollect();
            userCollect.setShop(shop);
            userCollect.setUser(user);
            userCollectDAO.save(userCollect);
            status.setState(true);
            status.setMsg("添加成功");
        }
        catch (Exception e){
            status.setState(false);
            status.setMsg("添加失败");
        }
        return status;
    }

    public Status deleteCollection(CreateCollectionRequest createCollectionRequest, HttpServletRequest request){
        Status status = new Status();
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        try{
            User user = userDAO.findUserByUserId(userId);
            Shop shop = shopDAO.findShopByShopId(createCollectionRequest.getShopId());
            UserCollect userCollect = userCollectDAO.findByUserAndShop(user, shop);
            userCollectDAO.delete(userCollect);
            status.setState(true);
            status.setMsg("删除成功");
        }
        catch (Exception e){
            status.setState(false);
            status.setMsg("删除失败");
        }
        return status;
    }

}
