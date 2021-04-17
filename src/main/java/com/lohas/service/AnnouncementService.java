package com.lohas.service;

import com.lohas.common.PaginationSend;
import com.lohas.dao.ShopAnnouncementDAO;
import com.lohas.dao.ShopDAO;
import com.lohas.exception.AnnouncementDoesNotExistException;
import com.lohas.model.Shop;
import com.lohas.model.ShopAnnouncement;
import com.lohas.request.CreateAnnouncementRequest;
import com.lohas.request.DeleteAnnouncementRequest;
import com.lohas.request.QueryByShopRequest;
import com.lohas.request.UpdateAnnouncementRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.AnnouncementItem;
import com.lohas.view.AnnouncementPage;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class AnnouncementService {

    @Autowired
    ShopAnnouncementDAO shopAnnouncementDAO;
    @Autowired
    ShopDAO shopDAO;

    public Status createAnnouncement(CreateAnnouncementRequest announcementRequest, HttpServletRequest request){
        Status status = new Status();
        try {
            Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
            ShopAnnouncement shopAnnouncement = new ShopAnnouncement();
            shopAnnouncement.setContent(announcementRequest.getContent());
            shopAnnouncement.setShop(shopDAO.findShopByShopId(shopId));
            shopAnnouncement.setTitle(announcementRequest.getTitle());
            shopAnnouncement.setPublishTime(new Date());

            shopAnnouncementDAO.save(shopAnnouncement);

            status.setState(true);
            status.setMsg("发布成功");
        }
        catch (Exception e){
            status.setState(false);
            status.setMsg("发布失败");
        }
        return status;
    }

    public Status updateAnnouncement(UpdateAnnouncementRequest updateAnnouncementRequest, HttpServletRequest request){
        Status status = new Status();
        try {
            ShopAnnouncement shopAnnouncement = shopAnnouncementDAO.findShopAnnouncementByAnnouncementId(updateAnnouncementRequest.getAnnouncementId());
            Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
            if(shopAnnouncement==null || !shopAnnouncement.getShop().getShopId().equals(shopId)){
                throw new AnnouncementDoesNotExistException();
            }
            shopAnnouncement.setTitle(updateAnnouncementRequest.getTitle());
            shopAnnouncement.setContent(updateAnnouncementRequest.getContext());
            shopAnnouncement.setPublishTime(new Date());
            shopAnnouncementDAO.save(shopAnnouncement);
            status.setState(true);
            status.setMsg("更新成功");
        } catch (AnnouncementDoesNotExistException e) {
            status.setState(false);
            status.setMsg("更新失败");
        }
        return status;
    }

    public Status deleteAnnouncement(DeleteAnnouncementRequest deleteAnnouncementRequest, HttpServletRequest request){
        Status status =new Status();
        try {
            ShopAnnouncement shopAnnouncement = shopAnnouncementDAO.findShopAnnouncementByAnnouncementId(deleteAnnouncementRequest.getAnnouncementId());
            Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
            if(shopAnnouncement==null || !shopAnnouncement.getShop().getShopId().equals(shopId)){
                throw new AnnouncementDoesNotExistException();
            }
            shopAnnouncementDAO.delete(shopAnnouncement);
            status.setState(true);
            status.setMsg("删除成功");
        } catch (AnnouncementDoesNotExistException e) {
            status.setState(false);
            status.setMsg("删除失败");
        }
        return status;
    }

    public AnnouncementPage getAnnouncementOfOneShop(QueryByShopRequest queryByShopRequest, HttpServletRequest request){
        Shop shop = shopDAO.findShopByShopId(queryByShopRequest.getShopId());
        return new AnnouncementPage(shopAnnouncementDAO.findAllByShop(shop,
                PageRequest.of(queryByShopRequest.getPageNum() - 1, queryByShopRequest.getPageSize())));
    }

    public AnnouncementPage getAnnouncementOfMine(PaginationSend paginationSend ,HttpServletRequest request){
        Integer shopId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("shop_id").asString());
        return new AnnouncementPage(shopAnnouncementDAO.findAllByShop(shopDAO.findShopByShopId(shopId),
                PageRequest.of(paginationSend.getPageNum() - 1, paginationSend.getPageSize())));
    }

    public AnnouncementItem getAnnouncementById(Integer Id){
        ShopAnnouncement a = shopAnnouncementDAO.findShopAnnouncementByAnnouncementId(Id);
        AnnouncementItem item = new AnnouncementItem();
        item.setAnnouncementId(a.getAnnouncementId());
        item.setContent(a.getContent());
        item.setPublishTime(a.getPublishTime());
        item.setTitle(a.getTitle());
        return item;
    }
}
