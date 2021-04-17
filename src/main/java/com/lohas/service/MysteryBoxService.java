package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.MysteryBoxDAO;
import com.lohas.dao.ShopDAO;
import com.lohas.model.ForsaleProduct;
import com.lohas.model.MysteryBox;
import com.lohas.model.Shop;
import com.lohas.request.CreateMysteryBoxRequest;
import com.lohas.request.DeleteProductRequest;
import com.lohas.request.QueryByShopRequest;
import com.lohas.request.UpdateMysteryBoxRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.ForsaleProductItem;
import com.lohas.view.MysteryBoxItem;
import com.lohas.view.MysteryBoxPage;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class MysteryBoxService {
    @Autowired
    MysteryBoxDAO mysteryBoxDAO;
    @Autowired
    ShopDAO shopDAO;

    public Status createMysteryBox(CreateMysteryBoxRequest createMysteryBoxRequest, HttpServletRequest request){
        Status status = new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            Shop shop = shopDAO.findShopByShopId(shopId);
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.setShop(shop);
            mysteryBox.setPrice(createMysteryBoxRequest.getPrice());
            mysteryBox.setProductName(createMysteryBoxRequest.getProductName());
            mysteryBox.setProductIntro(createMysteryBoxRequest.getProductIntro());
            mysteryBox.setProductPic(createMysteryBoxRequest.getProductPic());
            mysteryBox.setProductPubdate(new Date());
            mysteryBoxDAO.save(mysteryBox);
            status.setState(true);
            status.setMsg("添加成功");
        }
        catch (Exception e){
            status.setState(false);
            status.setMsg("添加失败");
        }
        return status;
    }

    public Status updateMysteryBox(UpdateMysteryBoxRequest updateMysteryBoxRequest, HttpServletRequest request){
        Status status = new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            MysteryBox mysteryBox = mysteryBoxDAO.findByProductId(updateMysteryBoxRequest.getProductId());
            if(mysteryBox==null || !mysteryBox.getShop().getShopId().equals(shopId)){
                throw new Exception("促销商品不存在");
            }
            mysteryBox.setProductIntro(updateMysteryBoxRequest.getProductIntro());
            //MysteryBox.setProductPubdate(new Date());
            mysteryBox.setProductName(updateMysteryBoxRequest.getProductName());
            mysteryBox.setPrice(updateMysteryBoxRequest.getPrice());
            mysteryBox.setProductPic(updateMysteryBoxRequest.getProductPic());
            mysteryBoxDAO.save(mysteryBox);
            status.setState(true);
            status.setMsg("更新成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("更新失败");
        }
        return status;
    }

    public Status deleteMysteryBox(DeleteProductRequest deleteMysteryBoxRequest, HttpServletRequest request){
        Status status =new Status();
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        try{
            MysteryBox mysteryBox = mysteryBoxDAO.findByProductId(deleteMysteryBoxRequest.getProductId());
            if(mysteryBox==null || !mysteryBox.getShop().getShopId().equals(shopId)){
                throw new Exception("促销商品不存在");
            }
            mysteryBoxDAO.delete(mysteryBox);
            status.setState(true);
            status.setMsg("删除成功");
        } catch (Exception e) {
            status.setState(false);
            status.setMsg("删除失败");
        }
        return status;
    }

    public MysteryBoxPage getMysteryBoxOfOneShop(QueryByShopRequest queryMysteryBoxByShopRequest, HttpServletRequest request){
        //此请求和查询商店的公告格式相同，不再设立新的类
        Shop shop = shopDAO.findShopByShopId(queryMysteryBoxByShopRequest.getShopId());
        return new MysteryBoxPage(mysteryBoxDAO.findAllByShop(shop,
                PageRequest.of(queryMysteryBoxByShopRequest.getPageNum() - 1, queryMysteryBoxByShopRequest.getPageSize())));
    }

    public MysteryBoxPage getMyProduct(PaginationSend paginationSend, HttpServletRequest request){
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        return new MysteryBoxPage(mysteryBoxDAO.findAllByShop(shopDAO.findShopByShopId(shopId),
                PageRequest.of(paginationSend.getPageNum() - 1, paginationSend.getPageSize())));
    }

    public MysteryBoxItem getMysteryBoxById(Integer Id){
        MysteryBox prod = mysteryBoxDAO.findByProductId(Id);
        MysteryBoxItem item = new MysteryBoxItem();
        item.setProductId(prod.getProductId());
        item.setProductName(prod.getProductName());
        item.setProductPic(prod.getProductPic());
        item.setProductIntro(prod.getProductIntro());
        item.setProductPubdate(prod.getProductPubdate());
        item.setPrice(prod.getPrice());
        return item;
    }
}
