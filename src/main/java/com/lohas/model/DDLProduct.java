package com.lohas.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ddl_product")
public class DDLProduct {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    private Shop shop;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_intro")
    private String productIntro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "product_pubdate")
    private Date productPubdate;

    @Column(name = "origin_cost")
    private Double originCost;

    @Column(name = "current_cost")
    private Double currentCost;

    @Formula("Cast((select origin_cost from forsale_product f where f.product_id = product_id)" +
            "/(select current_cost from forsale_product f where f.product_id = product_id) As Dec(4,1))")
    private Double discount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "production_date")
    private Date productionDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expiry_date")
    private Date expiryDate;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIntro() {
        return productIntro;
    }

    public void setProductIntro(String productIntro) {
        this.productIntro = productIntro;
    }

    public Date getProductPubdate() {
        return productPubdate;
    }

    public void setProductPubdate(Date productPubdate) {
        this.productPubdate = productPubdate;
    }

    public Double getOriginCost() {
        return originCost;
    }

    public void setOriginCost(Double originCost) {
        this.originCost = originCost;
    }

    public Double getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(Double currentCost) {
        this.currentCost = currentCost;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
