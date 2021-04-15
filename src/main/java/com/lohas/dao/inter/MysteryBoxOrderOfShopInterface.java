package com.lohas.dao.inter;

import java.util.Date;

public interface MysteryBoxOrderOfShopInterface {
    Integer getUser_Id();
    Integer getMystery_Box_Id();
    String getUser_Name();
    String getAvatar();
    Date getOrder_Time();
    Boolean getIs_Taken();
}
