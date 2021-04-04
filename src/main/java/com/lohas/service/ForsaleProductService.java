package com.lohas.service;

import com.lohas.dao.ForsaleProductDAO;
import com.lohas.dao.ShopDAO;
import com.lohas.model.ForsaleProduct;
import com.lohas.model.Shop;
import com.lohas.request.CreateForsaleProductRequest;
import com.lohas.request.DeleteForsaleProductRequest;
import com.lohas.request.QueryAnnouncementByShopRequest;
import com.lohas.request.UpdateForsaleProductRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.ForsaleProductPage;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class ForsaleProductService {
    @Autowired
    ForsaleProductDAO forsaleProductDAO;
    @Autowired
    ShopDAO shopDAO;

    public Status createForsaleProduct(CreateForsaleProductRequest createForsaleProductRequest, HttpServletRequest request){
        Status status = new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            Shop shop = shopDAO.findShopByShopId(shopId);
            ForsaleProduct forsaleProduct = new ForsaleProduct();
            forsaleProduct.setShop(shop);
            forsaleProduct.setCurrentCost(createForsaleProductRequest.getCurrentCost());
            forsaleProduct.setOriginCost(createForsaleProductRequest.getOriginCost());
            forsaleProduct.setProductName(createForsaleProductRequest.getProductName());
            forsaleProduct.setProductIntro(createForsaleProductRequest.getProductIntro());
            forsaleProduct.setProductPubdate(new Date());
            forsaleProductDAO.save(forsaleProduct);
            status.setState(true);
            status.setMsg("添加成功");
        }
        catch (Exception e){
            status.setState(false);
            status.setMsg("添加失败");
        }
        return status;
    }

    public Status updateForsaleProduct(UpdateForsaleProductRequest updateForsaleProductRequest, HttpServletRequest request){
        Status status = new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            ForsaleProduct forsaleProduct = forsaleProductDAO.findByProductId(updateForsaleProductRequest.getProductId());
            if(forsaleProduct==null || !forsaleProduct.getShop().getShopId().equals(shopId)){
                throw new Exception("促销商品不存在");
            }
            forsaleProduct.setProductIntro(updateForsaleProductRequest.getProductIntro());
            //ForsaleProduct.setProductPubdate(new Date());
            forsaleProduct.setProductName(updateForsaleProductRequest.getProductName());
            forsaleProduct.setOriginCost(updateForsaleProductRequest.getOriginCost());
            forsaleProduct.setCurrentCost(updateForsaleProductRequest.getCurrentCost());
            forsaleProductDAO.save(forsaleProduct);
            status.setState(true);
            status.setMsg("更新成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("更新失败");
        }
        return status;
    }

    public Status deleteForsaleProduct(DeleteForsaleProductRequest deleteForsaleProductRequest, HttpServletRequest request){
        Status status =new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            ForsaleProduct forsaleProduct = forsaleProductDAO.findByProductId(deleteForsaleProductRequest.getProductId());
            if(forsaleProduct==null || !forsaleProduct.getShop().getShopId().equals(shopId)){
                throw new Exception("促销商品不存在");
            }
            forsaleProductDAO.delete(forsaleProduct);
            status.setState(true);
            status.setMsg("删除成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("删除失败");
        }
        return status;
    }

    public ForsaleProductPage getForsaleProductOfOneShop(QueryAnnouncementByShopRequest queryForsaleProductByShopRequest, HttpServletRequest request){
        //此请求和查询商店的公告格式相同，不再设立新的类
        Shop shop = shopDAO.findShopByShopId(queryForsaleProductByShopRequest.getShopId());
        return new ForsaleProductPage(forsaleProductDAO.findAllByShop(shop,
                PageRequest.of(queryForsaleProductByShopRequest.getPageNum() - 1, queryForsaleProductByShopRequest.getPageSize())));
    }

}
