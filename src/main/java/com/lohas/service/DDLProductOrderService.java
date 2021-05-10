package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.DDLProductDAO;
import com.lohas.dao.DDLProductOrderDAO;
import com.lohas.dao.ShopDAO;
import com.lohas.dao.UserDAO;
import com.lohas.dao.inter.GreenPointInterface;
import com.lohas.dao.inter.MysteryBoxOrderOfShopInterface;
import com.lohas.dao.inter.MysteryBoxOrderOfUserInterface;
import com.lohas.model.DDLProduct;
import com.lohas.model.DDLProductOrder;
import com.lohas.model.MysteryBoxOrder;
import com.lohas.request.MysteryBoxOrderRequest;
import com.lohas.request.PlaceMysteryBoxRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.GreenPointList;
import com.lohas.view.MysteryBoxOrderOfShopPage;
import com.lohas.view.MysteryBoxOrderOfUserPage;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class DDLProductOrderService {
    @Autowired
    DDLProductOrderDAO ddlProductOrderDAO;
    @Autowired
    DDLProductDAO ddlProductDAO;
    @Autowired
    UserDAO userDAO;

    public Status placeDDLProductOrder(PlaceMysteryBoxRequest placeDDLProductRequest, HttpServletRequest request){
        Status status = new Status();
        try {
            Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
//            Integer todayOrderCount = ddlProductOrderDAO.findOrderCountByUserAndDate(userId);
//            if(todayOrderCount>0){
//                status.setState(false);
//                status.setMsg("同一天只能订购一个临期食品");
//                return status;
//            }
            DDLProductOrder ddlProductOrder = new DDLProductOrder();
            ddlProductOrder.setIsTaken(false);
            ddlProductOrder.setDdlProduct(ddlProductDAO.findByProductId(placeDDLProductRequest.getProductId()));
            ddlProductOrder.setOrderTime(new Date());
            ddlProductOrder.setUser(userDAO.findUserByUserId(userId));
            ddlProductOrderDAO.save(ddlProductOrder);
            status.setState(true);
            status.setMsg("下订单成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("下订单失败");
        }
        return status;
    }

    public Status dealDDLProductTaken(MysteryBoxOrderRequest ddlProductOrderRequest, HttpServletRequest request){
        Status status = new Status();
        try {
            Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
            DDLProductOrder ddlProductOrder = ddlProductOrderDAO.findByOrderId(ddlProductOrderRequest.getOrderId());
            Integer ddlProductId = ddlProductOrder.getDdlProduct().getProductId();
            if(!ddlProductDAO.findByProductId(ddlProductId).getShop().getShopId().equals(shopId)){
                status.setState(false);
                status.setMsg("店铺与商品不匹配");
                return status;
            }
            ddlProductOrder.setIsTaken(true);
            ddlProductOrderDAO.save(ddlProductOrder);
            status.setState(true);
            status.setMsg("操作成功");
        }catch (Exception e) {
            status.setState(false);
            status.setMsg("操作失败");
        }
        return status;
    }

    public MysteryBoxOrderOfShopPage queryDDLProductOfMyShop(PaginationSend paginationSend, HttpServletRequest request){
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        Page<MysteryBoxOrderOfShopInterface> mysteryBoxOrderOfShopInterfacePage = ddlProductOrderDAO.findDDLProductOrderByShop(shopId,
                PageRequest.of(
                        paginationSend.getPageNum() - 1,
                        paginationSend.getPageSize()
                )
        );
        return new MysteryBoxOrderOfShopPage(mysteryBoxOrderOfShopInterfacePage);
    }

    public MysteryBoxOrderOfUserPage queryDDLProductOfUser(PaginationSend paginationSend, HttpServletRequest request){
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        Page<MysteryBoxOrderOfUserInterface> mysteryBoxOrderOfUserInterfacePage = ddlProductOrderDAO.findDDLProductOrderByUser(userId,
                PageRequest.of(
                        paginationSend.getPageNum() - 1,
                        paginationSend.getPageSize()
                )
        );
        return new MysteryBoxOrderOfUserPage(mysteryBoxOrderOfUserInterfacePage);
    }
    public GreenPointList queryGreenPoint(HttpServletRequest request){
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        List<GreenPointInterface> greenPointInterfaceList = ddlProductOrderDAO.getGreenPointOfUser(userId);
        Integer totalPoint = ddlProductOrderDAO.getTotalPoint(userId);
        return new GreenPointList(greenPointInterfaceList,totalPoint);
    }
}
