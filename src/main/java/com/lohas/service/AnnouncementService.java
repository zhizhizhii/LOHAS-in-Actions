package com.lohas.service;

import com.lohas.dao.ShopAnnouncementDAO;
import com.lohas.dao.ShopDAO;
import com.lohas.exception.AnnouncementDoesNotExistException;
import com.lohas.model.Shop;
import com.lohas.model.ShopAnnouncement;
import com.lohas.request.CreateAnnouncementRequest;
import com.lohas.request.DeleteAnnouncementRequest;
import com.lohas.request.QueryAnnouncementByShopRequest;
import com.lohas.request.UpdateAnnouncementRequest;
import com.lohas.utils.JWTUtils;
import com.lohas.view.AnnouncementItem;
import com.lohas.view.AnnouncementPage;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

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

    public AnnouncementPage getAnnouncementOfOneShop(QueryAnnouncementByShopRequest queryAnnouncementByShopRequest, HttpServletRequest request){
        Shop shop = shopDAO.findShopByShopId(queryAnnouncementByShopRequest.getShopId());
        return new AnnouncementPage(shopAnnouncementDAO.findAllByShop(shop,
                PageRequest.of(queryAnnouncementByShopRequest.getPageNum() - 1, queryAnnouncementByShopRequest.getPageSize())));
    }
}
