package com.lohas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "ddl_product_order")
public class DDLProductOrder {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private DDLProduct ddlProduct;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "order_time")
    private Date orderTime;

    @Column(name = "is_taken")
    private Boolean isTaken;
    //表示是否被领取
}
