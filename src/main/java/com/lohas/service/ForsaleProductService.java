package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.ForsaleProductDAO;
import com.lohas.dao.ShopDAO;
import com.lohas.model.DDLProduct;
import com.lohas.model.ForsaleProduct;
import com.lohas.model.Shop;
import com.lohas.request.CreateForsaleProductRequest;
import com.lohas.request.DeleteProductRequest;
import com.lohas.request.QueryByShopRequest;
import com.lohas.request.UpdateForsaleProductRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.DDLProductItem;
import com.lohas.view.ForsaleProductItem;
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
            forsaleProduct.setProductPic(createForsaleProductRequest.getProductPic());
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
            forsaleProduct.setProductPic(updateForsaleProductRequest.getProductPic());
            forsaleProductDAO.save(forsaleProduct);
            status.setState(true);
            status.setMsg("更新成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("更新失败");
        }
        return status;
    }

    public Status deleteForsaleProduct(DeleteProductRequest deleteForsaleProductRequest, HttpServletRequest request){
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

    public ForsaleProductPage getForsaleProductOfOneShop(QueryByShopRequest queryForsaleProductByShopRequest, HttpServletRequest request){
        //此请求和查询商店的公告格式相同，不再设立新的类
        Shop shop = shopDAO.findShopByShopId(queryForsaleProductByShopRequest.getShopId());
        return new ForsaleProductPage(forsaleProductDAO.findAllByShop(shop,
                PageRequest.of(queryForsaleProductByShopRequest.getPageNum() - 1, queryForsaleProductByShopRequest.getPageSize())));
    }

    public ForsaleProductPage getMyProduct(PaginationSend paginationSend,HttpServletRequest request){
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        return new ForsaleProductPage(forsaleProductDAO.findAllByShop(shopDAO.findShopByShopId(shopId),
                PageRequest.of(paginationSend.getPageNum() - 1, paginationSend.getPageSize())));
    }

    public ForsaleProductItem getForsaleProductById(Integer Id){
        ForsaleProduct prod = forsaleProductDAO.findByProductId(Id);
        ForsaleProductItem item = new ForsaleProductItem();
        item.setProductId(prod.getProductId());
        item.setProductName(prod.getProductName());
        item.setProductPic(prod.getProductPic());
        item.setCurrentCost(prod.getCurrentCost());
        item.setDiscount(prod.getDiscount());
        item.setOriginCost(prod.getOriginCost());
        item.setProductIntro(prod.getProductIntro());
        item.setProductPubdate(prod.getProductPubdate());
        return item;
    }

}
