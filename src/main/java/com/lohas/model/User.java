package com.lohas.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(name = "open_id")
    private String openId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_time")
    private Date registerTime;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserCollect> userCollects;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<UserComment> userComments;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
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
}
