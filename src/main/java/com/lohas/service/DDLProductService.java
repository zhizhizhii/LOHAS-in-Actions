package com.lohas.service;

import com.lohas.dao.DDLProductDAO;
import com.lohas.dao.ShopDAO;
import com.lohas.model.DDLProduct;
import com.lohas.model.Shop;
import com.lohas.request.*;
import com.lohas.utils.JWTUtils;
import com.lohas.view.DDLProductPage;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class DDLProductService {
    @Autowired
    DDLProductDAO ddlProductDAO;
    @Autowired
    ShopDAO shopDAO;

    public Status createDDLProduct(CreateDDLProductRequest createDDLProductRequest, HttpServletRequest request){
        Status status = new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            Shop shop = shopDAO.findShopByShopId(shopId);
            DDLProduct ddlProduct = new DDLProduct();
            ddlProduct.setShop(shop);
            ddlProduct.setCurrentCost(createDDLProductRequest.getCurrentCost());
            ddlProduct.setOriginCost(createDDLProductRequest.getOriginCost());
            ddlProduct.setProductName(createDDLProductRequest.getProductName());
            ddlProduct.setProductIntro(createDDLProductRequest.getProductIntro());
            ddlProduct.setExpiryDate(createDDLProductRequest.getExpiryDate());
            ddlProduct.setProductionDate(createDDLProductRequest.getProductionDate());
            ddlProduct.setProductPubdate(new Date());
            ddlProductDAO.save(ddlProduct);
            status.setState(true);
            status.setMsg("添加成功");
        }
        catch (Exception e){
            status.setState(false);
            status.setMsg("添加失败");
        }
        return status;
    }

    public Status updateDDLProduct(UpdateDDLProductRequest updateDDLProductRequest, HttpServletRequest request){
        Status status = new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            DDLProduct ddlProduct = ddlProductDAO.findByProductId(updateDDLProductRequest.getProductId());
            if(ddlProduct==null || !ddlProduct.getShop().getShopId().equals(shopId)){
                throw new Exception("临期商品不存在");
            }
            ddlProduct.setProductIntro(updateDDLProductRequest.getProductIntro());
            //ddlProduct.setProductPubdate(new Date());
            ddlProduct.setProductionDate(updateDDLProductRequest.getProductionDate());
            ddlProduct.setExpiryDate(updateDDLProductRequest.getExpiryDate());
            ddlProduct.setProductName(updateDDLProductRequest.getProductName());
            ddlProduct.setOriginCost(updateDDLProductRequest.getOriginCost());
            ddlProduct.setCurrentCost(updateDDLProductRequest.getCurrentCost());
            ddlProductDAO.save(ddlProduct);
            status.setState(true);
            status.setMsg("更新成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("更新失败");
        }
        return status;
    }

    public Status deleteDDLProduct(DeleteDDLProductRequest deleteDDLProductRequest, HttpServletRequest request){
        Status status =new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            DDLProduct ddlProduct = ddlProductDAO.findByProductId(deleteDDLProductRequest.getProductId());
            if(ddlProduct==null || !ddlProduct.getShop().getShopId().equals(shopId)){
                throw new Exception("临期商品不存在");
            }
            ddlProductDAO.delete(ddlProduct);
            status.setState(true);
            status.setMsg("删除成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("删除失败");
        }
        return status;
    }

    public DDLProductPage getDDLProductOfOneShop(QueryAnnouncementByShopRequest queryDDLProductByShopRequest, HttpServletRequest request){
        //此请求和查询商店的公告格式相同，不再设立新的类
        Shop shop = shopDAO.findShopByShopId(queryDDLProductByShopRequest.getShopId());
        return new DDLProductPage(ddlProductDAO.findAllByShop(shop,
                PageRequest.of(queryDDLProductByShopRequest.getPageNum() - 1, queryDDLProductByShopRequest.getPageSize())));
    }
}
