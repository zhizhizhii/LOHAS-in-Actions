package com.lohas.dao.inter;

import java.util.Date;

public interface MysteryBoxOrderOfShopInterface {
    Integer getUser_Id();
    Integer getOrder_Id();
    String getUser_Name();
    String getAvatar();
    Date getOrder_Time();
    Boolean getIs_Taken();
    Integer getProduct_Id();
    String getProduct_Pic();
    String getProduct_Name();
}
