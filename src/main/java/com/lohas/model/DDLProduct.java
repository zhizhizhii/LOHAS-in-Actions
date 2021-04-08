package com.lohas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "product_pubdate")
    private Date productPubdate;

    @Column(name = "origin_cost")
    private Double originCost;

    @Column(name = "current_cost")
    private Double currentCost;

    @Formula("Cast((select current_cost from ddl_product d where d.product_id = product_id)" +
            "/(select origin_cost from ddl_product d where d.product_id = product_id) As Dec(4,2))")
    private Double discount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "production_date")
    private Date productionDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "product_pic")
    private String productPic;
}
