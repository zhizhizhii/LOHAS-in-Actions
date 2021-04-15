package com.lohas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "mystery_box")
public class MysteryBox {
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

    @Column(name = "price")
    private Double price;

    @Column(name = "product_pic")
    private String productPic;
}
