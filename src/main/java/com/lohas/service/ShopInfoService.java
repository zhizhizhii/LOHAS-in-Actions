package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.ShopDAO;
import com.lohas.dao.ShopInfoDAO;
import com.lohas.dao.UserCollectDAO;
import com.lohas.dao.UserDAO;
import com.lohas.model.*;
import com.lohas.request.QueryShopByTypeAndNameRequest;
import com.lohas.request.QueryShopInfoByNameRequest;
import com.lohas.request.QueryShopInfoByTypeRequest;
import com.lohas.request.UpdateShopInfoRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopInfoService {

    @Autowired
    ShopInfoDAO shopInfoDAO;

    @Autowired
    ShopDAO shopDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserCollectDAO userCollectDAO;

    public ShopBriefInfoPage getShopBriefInfo(PaginationSend paginationSend, HttpServletRequest request){

        Page<ShopInfo> page =  shopInfoDAO.findAll(
                            PageRequest.of(
                                    paginationSend.getPageNum() - 1,
                                    paginationSend.getPageSize()
                            )
        );

        return new ShopBriefInfoPage(page);

    }


    public ShopDetailedInfoWithCollectPage getShopDetailedInfoWithCollect(PaginationSend paginationSend, HttpServletRequest request){

        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        Page<ShopInfo> page =  shopInfoDAO.findAll(
                PageRequest.of(
                        paginationSend.getPageNum() - 1,
                        paginationSend.getPageSize()
                )
        );

        List<ShopInfo> list = page.getContent();
        List<Integer> result = new ArrayList<Integer>();
        for(ShopInfo item : list){
            UserCollect u = userCollectDAO.findByUserAndShop(userDAO.findUserByUserId(userId),
                    item.getShop());
            if(u==null){
                result.add(0);
            }
            else{
                result.add(1);
            }
        }
        return new ShopDetailedInfoWithCollectPage(page,result);
    }


    public ShopBriefInfoPage getShopBriefInfoByName(QueryShopInfoByNameRequest queryShopInfoByNameRequest){

        Page<ShopInfo> page =  shopInfoDAO.findByShopNameLike(
                queryShopInfoByNameRequest.getKeyword(),
                PageRequest.of(
                        queryShopInfoByNameRequest.getPageNum() - 1,
                        queryShopInfoByNameRequest.getPageSize()
                )
        );

        return new ShopBriefInfoPage(page);

    }


    public ShopBriefInfoPage getShopBriefInfoByType(QueryShopInfoByTypeRequest queryShopInfoByTypeRequest){

        Page<ShopInfo> page =  shopInfoDAO.findAllByShopType(
                queryShopInfoByTypeRequest.getShopType(),
                PageRequest.of(
                        queryShopInfoByTypeRequest.getPageNum() - 1,
                        queryShopInfoByTypeRequest.getPageSize()
                )
        );

        return new ShopBriefInfoPage(page);

    }


    public ShopBriefInfoPage getShopBriefInfoByTypeAndName(QueryShopByTypeAndNameRequest queryShopByTypeAndNameRequest){

        Page<ShopInfo> page =  shopInfoDAO.findAllByShopTypeAndShopNameLike(
                queryShopByTypeAndNameRequest.getShopType(),
                queryShopByTypeAndNameRequest.getKeyword(),
                PageRequest.of(
                        queryShopByTypeAndNameRequest.getPageNum() - 1,
                        queryShopByTypeAndNameRequest.getPageSize()
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

    public ShopDetailedInfo getShopInfoMine(HttpServletRequest request){
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());

        ShopInfo info = shopInfoDAO.findShopInfoByShop(shopDAO.findShopByShopId(shopId));
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



}
