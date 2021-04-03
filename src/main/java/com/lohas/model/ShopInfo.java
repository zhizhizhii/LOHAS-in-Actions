package com.lohas.model;

import javax.persistence.*;

@Entity
@Table(name = "shop_info")
public class ShopInfo {

    @Id
    @Column(name = "shop_info_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shopInfoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_type")
    private String shopType;

    @Column(name = "shop_intro")
    private String shopIntro;

    @Column(name = "shop_lohas_info")
    private String shopLohasInfo;

    @Column(name = "shop_address")
    private String shopAddress;

    @Column(name = "shop_business_hours")
    private String shopBusinessHours;

    @Column(name = "shop_longitude")
    private Float shopLongitude;

    @Column(name = "shop_latitude")
    private Float shopLatitude;

    private String avatar;

    private String headPicture;

    public Integer getShopInfoId() {
        return shopInfoId;
    }

    public void setShopInfoId(Integer shopInfoId) {
        this.shopInfoId = shopInfoId;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getShopIntro() {
        return shopIntro;
    }

    public void setShopIntro(String shopIntro) {
        this.shopIntro = shopIntro;
    }

    public String getShopLohasInfo() {
        return shopLohasInfo;
    }

    public void setShopLohasInfo(String shopLohasInfo) {
        this.shopLohasInfo = shopLohasInfo;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopBusinessHours() {
        return shopBusinessHours;
    }

    public void setShopBusinessHours(String shopBusinessHours) {
        this.shopBusinessHours = shopBusinessHours;
    }

    public Float getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(Float shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

    public Float getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(Float shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }
}
