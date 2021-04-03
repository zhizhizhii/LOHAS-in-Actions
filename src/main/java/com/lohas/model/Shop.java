package com.lohas.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shopId;

    private String username;

    private String password;

    private String salt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_time")
    private Date registerTime;

    @OneToOne(mappedBy = "shop",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ShopInfo shopInfo;

    @OneToMany(mappedBy = "shop",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserCollect> userCollects;

    @OneToMany(mappedBy = "shop",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserComment> userComments;

    @OneToMany(mappedBy = "shop",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ShopAnnouncement> shopAnnouncements;

    @OneToMany(mappedBy = "shop",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ForsaleProduct> forsaleProducts;

    @OneToMany(mappedBy = "shop",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<DDLProduct> ddlProducts;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public ShopInfo getShopInfo() {
        return shopInfo;
    }

    public void setShopInfo(ShopInfo shopInfo) {
        this.shopInfo = shopInfo;
    }

    public Set<UserCollect> getUserCollects() {
        return userCollects;
    }

    public void setUserCollects(Set<UserCollect> userCollects) {
        this.userCollects = userCollects;
    }

    public Set<UserComment> getUserComments() {
        return userComments;
    }

    public void setUserComments(Set<UserComment> userComments) {
        this.userComments = userComments;
    }

    public Set<ShopAnnouncement> getShopAnnouncements() {
        return shopAnnouncements;
    }

    public void setShopAnnouncements(Set<ShopAnnouncement> shopAnnouncements) {
        this.shopAnnouncements = shopAnnouncements;
    }

    public Set<ForsaleProduct> getForsaleProducts() {
        return forsaleProducts;
    }

    public void setForsaleProducts(Set<ForsaleProduct> forsaleProducts) {
        this.forsaleProducts = forsaleProducts;
    }

    public Set<DDLProduct> getDdlProducts() {
        return ddlProducts;
    }

    public void setDdlProducts(Set<DDLProduct> ddlProducts) {
        this.ddlProducts = ddlProducts;
    }
}
