package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.ShopDAO;
import com.lohas.dao.ShopInfoDAO;
import com.lohas.dao.UserCollectDAO;
import com.lohas.dao.UserDAO;
import com.lohas.model.Shop;
import com.lohas.model.ShopInfo;
import com.lohas.model.User;
import com.lohas.model.UserCollect;
import com.lohas.request.CreateCollectionRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.ShopBriefInfoPage;
import com.lohas.view.ShopDetailedInfo;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    ShopInfoDAO shopInfoDAO;

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

    public ShopBriefInfoPage getCollection(PaginationSend paginationSend, HttpServletRequest request){
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());

        Page<ShopInfo> page =  shopInfoDAO.findCollectInfo(userId,
                PageRequest.of(
                        paginationSend.getPageNum() - 1,
                        paginationSend.getPageSize()
                )
        );

        return new ShopBriefInfoPage(page);
    }



}
