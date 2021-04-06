package com.lohas.model;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "forsale_product")
public class ForsaleProduct {

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

    @Column(name = "product_pic")
    private String productPic;
}
