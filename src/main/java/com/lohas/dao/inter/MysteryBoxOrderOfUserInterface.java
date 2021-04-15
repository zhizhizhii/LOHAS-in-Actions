package com.lohas.dao.inter;

import java.util.Date;

public interface MysteryBoxOrderOfUserInterface {
    public Integer getOrder_Id();
    public Integer getShop_Id();
    public String getShop_Name();
    public String getAvatar();
    public String getIs_Tsken();
    public Date getOrder_Time();
    Integer getProduct_Id();
    String getProduct_Pic();
    String getProduct_Name();
}
