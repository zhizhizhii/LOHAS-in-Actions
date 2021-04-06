package com.lohas.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_info")
public class UserInfo{

    @Id
    @Column(name = "user_info_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userInfoId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    private User user;

    @Column(name = "user_name")
    private String userName;

    private String sex;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String avatar;



}
