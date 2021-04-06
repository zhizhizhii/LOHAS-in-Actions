package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.ShopDAO;
import com.lohas.dao.ShopInfoDAO;
import com.lohas.model.Shop;
import com.lohas.model.ShopInfo;
import com.lohas.model.User;
import com.lohas.model.UserInfo;
import com.lohas.request.UpdateShopInfoRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.DDLProductPage;
import com.lohas.view.ShopBriefInfoPage;
import com.lohas.view.ShopDetailedInfo;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ShopInfoService {

    @Autowired
    ShopInfoDAO shopInfoDAO;

    @Autowired
    ShopDAO shopDAO;

    public ShopBriefInfoPage getShopBriefInfo(PaginationSend paginationSend, HttpServletRequest request){

        Page<ShopInfo> page =  shopInfoDAO.findAll(
                            PageRequest.of(
                                    paginationSend.getPageNum() - 1,
                                    paginationSend.getPageSize()
                            )
        );

        return new ShopBriefInfoPage(page);

    }

    public ShopDetailedInfo getShopDetailedInfo(Integer ShopId){
        ShopInfo info = shopInfoDAO.findShopInfoByShop(shopDAO.findShopByShopId(ShopId));
        if(info==null)return null;

        ShopDetailedInfo detailedinfo = new ShopDetailedInfo();

        detailedinfo.setShopId(info.getShop().getShopId());
        detailedinfo.setShopName(info.getShopName());
        detailedinfo.setShopType(info.getShopType());
        detailedinfo.setShopIntro(info.getShopIntro());
        detailedinfo.setShopAddress(info.getShopAddress());
        detailedinfo.setShopBusinessHours(info.getShopBusinessHours());
        detailedinfo.setShopLohasInfo(info.getShopLohasInfo());
        detailedinfo.setShopLongitude(info.getShopLongitude());
        detailedinfo.setShopLatitude(info.getShopLatitude());
        detailedinfo.setAvatar(info.getAvatar());
        detailedinfo.setHeadPicture(info.getHeadPicture());

        return detailedinfo;

    }


    public Status updateShopInfo(UpdateShopInfoRequest updateShopInfoRequest, HttpServletRequest request){

        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        Shop s = shopDAO.findShopByShopId(shopId);
        Status status = new Status();
        if(s==null){
            status.setState(false);
            status.setMsg("用户不存在");
        }
        else{
            ShopInfo shopInfo = new ShopInfo();
            ShopInfo si = shopInfoDAO.findShopInfoByShop(s);
            if(si == null){
                shopInfo.setShop(s);
            }
            else{
                shopInfo = si;
            }
            shopInfo.setShopName(updateShopInfoRequest.getShopName());
            shopInfo.setShopAddress(updateShopInfoRequest.getShopAddress());
            shopInfo.setShopIntro(updateShopInfoRequest.getShopIntro());
            shopInfo.setShopType(updateShopInfoRequest.getShopType());
            shopInfo.setShopLohasInfo(updateShopInfoRequest.getShopLohasInfo());
            shopInfo.setShopBusinessHours(updateShopInfoRequest.getShopBusinessHours());
            shopInfo.setShopLongitude(updateShopInfoRequest.getShopLongitude());
            shopInfo.setShopLatitude(updateShopInfoRequest.getShopLatitude());
            shopInfo.setAvatar(updateShopInfoRequest.getAvatar());
            shopInfo.setHeadPicture(updateShopInfoRequest.getHeadPicture());
            shopInfoDAO.save(shopInfo);
            status.setState(true);
            status.setMsg("修改商户信息成功");
        }
        return status;

    }



}
