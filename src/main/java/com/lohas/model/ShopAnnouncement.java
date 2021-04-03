package com.lohas.model;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shop_announcement")
public class ShopAnnouncement {

    @Id
    @Column(name = "announcement_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer announcementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    private Shop shop;

    private String title;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="publish_time")
    private Date publishTime;

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
