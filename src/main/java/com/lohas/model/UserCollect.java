package com.lohas.model;

import com.lohas.model.pk.CollectPK;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user_collect")
public class UserCollect implements Serializable {

    private static final long serialVersionUID = -8473363729158033277L;

    @EmbeddedId
    private CollectPK id = new CollectPK();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    @MapsId("shopId")
    private Shop shop;
}
