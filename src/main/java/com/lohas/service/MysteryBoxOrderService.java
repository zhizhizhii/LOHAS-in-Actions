package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.MysteryBoxDAO;
import com.lohas.dao.MysteryBoxOrderDAO;
import com.lohas.dao.UserDAO;
import com.lohas.dao.inter.MysteryBoxOrderOfShopInterface;
import com.lohas.dao.inter.MysteryBoxOrderOfUserInterface;
import com.lohas.model.MysteryBoxOrder;
import com.lohas.request.MysteryBoxOrderRequest;
import com.lohas.request.PlaceMysteryBoxRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.MysteryBoxOrderOfShopPage;
import com.lohas.view.MysteryBoxOrderOfUserPage;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class MysteryBoxOrderService {
    @Autowired
    MysteryBoxOrderDAO mysteryBoxOrderDAO;
    @Autowired
    MysteryBoxDAO mysteryBoxDAO;
    @Autowired
    UserDAO userDAO;

    public Status placeMysteryBoxOrder(PlaceMysteryBoxRequest placeMysteryBoxRequest, HttpServletRequest request){
        Status status = new Status();
        try {
            Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
            Integer todayOrderCount = mysteryBoxOrderDAO.findOrderCountByUserAndDate(userId);
            if(todayOrderCount>2){
                status.setState(false);
                status.setMsg("同一天只能订购两个盲盒");
                return status;
            }
            MysteryBoxOrder mysteryBoxOrder = new MysteryBoxOrder();
            mysteryBoxOrder.setIsTaken(false);
            mysteryBoxOrder.setMysteryBox(mysteryBoxDAO.findByProductId(placeMysteryBoxRequest.getProductId()));
            mysteryBoxOrder.setOrderTime(new Date());
            mysteryBoxOrder.setUser(userDAO.findUserByUserId(userId));
            mysteryBoxOrderDAO.save(mysteryBoxOrder);
            status.setState(true);
            status.setMsg("下订单成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("下订单失败");
        }
        return status;
    }

    public Status dealMysteryBoxTaken(MysteryBoxOrderRequest mysteryBoxOrderRequest, HttpServletRequest request){
        Status status = new Status();
        try {
            Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
            MysteryBoxOrder mysteryBoxOrder = mysteryBoxOrderDAO.findByOrderId(mysteryBoxOrderRequest.getOrderId());
            Integer mysteryBoxId = mysteryBoxOrder.getMysteryBox().getProductId();
            if(!mysteryBoxDAO.findByProductId(mysteryBoxId).getShop().getShopId().equals(shopId)){
                status.setState(false);
                status.setMsg("店铺与商品不匹配");
                return status;
            }
            mysteryBoxOrder.setIsTaken(true);
            mysteryBoxOrderDAO.save(mysteryBoxOrder);
            status.setState(true);
            status.setMsg("操作成功");
        }catch (Exception e) {
            status.setState(false);
            status.setMsg("操作失败");
        }
        return status;
    }

    public MysteryBoxOrderOfShopPage queryMysteryBoxOfMyShop(PaginationSend paginationSend, HttpServletRequest request){
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        Page<MysteryBoxOrderOfShopInterface> mysteryBoxOrderOfShopInterfacePage = mysteryBoxOrderDAO.findMysteryBoxOrderByShop(shopId,
                PageRequest.of(
                        paginationSend.getPageNum() - 1,
                        paginationSend.getPageSize()
                )
        );
        return new MysteryBoxOrderOfShopPage(mysteryBoxOrderOfShopInterfacePage);
    }

    public MysteryBoxOrderOfUserPage queryMysteryBoxOfUser(PaginationSend paginationSend, HttpServletRequest request){
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        Page<MysteryBoxOrderOfUserInterface> mysteryBoxOrderOfUserInterfacePage = mysteryBoxOrderDAO.findMysteryBoxOrderByUser(userId,
                PageRequest.of(
                        paginationSend.getPageNum() - 1,
                        paginationSend.getPageSize()
                )
        );
        return new MysteryBoxOrderOfUserPage(mysteryBoxOrderOfUserInterfacePage);
    }
}
