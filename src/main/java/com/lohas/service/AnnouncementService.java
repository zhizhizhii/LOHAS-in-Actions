package com.lohas.service;

import com.lohas.dao.ShopAnnouncementDAO;
import com.lohas.exception.AnnouncementDoesNotExistException;
import com.lohas.model.ShopAnnouncement;
import com.lohas.request.CreateAnnouncementRequest;
import com.lohas.request.DeleteAnnouncementRequest;
import com.lohas.request.UpdateAnnouncementRequest;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnnouncementService {

    @Autowired
    ShopAnnouncementDAO shopAnnouncementDAO;

    public Status createAnnouncement(CreateAnnouncementRequest announcementRequest){
        Status status = new Status();
        try {
            ShopAnnouncement shopAnnouncement = new ShopAnnouncement();
            shopAnnouncement.setContent(announcementRequest.getContent());
            shopAnnouncement.setShop(announcementRequest.getShop());
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

    public Status updateAnnouncement(UpdateAnnouncementRequest updateAnnouncementRequest){
        Status status = new Status();
        try {
            ShopAnnouncement shopAnnouncement = shopAnnouncementDAO.findShopAnnouncementByAnnouncementId(updateAnnouncementRequest.getAnnouncementId());
            if(shopAnnouncement==null){
                //TODO: 检验是否为商家自身
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

    public Status deleteAnnouncement(DeleteAnnouncementRequest deleteAnnouncementRequest){
        Status status =new Status();
        try {
            ShopAnnouncement shopAnnouncement = shopAnnouncementDAO.findShopAnnouncementByAnnouncementId(deleteAnnouncementRequest.getAnnouncementId());
            if(shopAnnouncement==null){
                //TODO: 检验是否为商家自身
                throw new AnnouncementDoesNotExistException();
            }
            shopAnnouncementDAO.delete(shopAnnouncement);
            status.setState(true);
            status.setMsg("更新成功");
        } catch (AnnouncementDoesNotExistException e) {
            status.setState(false);
            status.setMsg("更新失败");
        }
        return status;
    }
}
