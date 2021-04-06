package com.lohas.dao.inter;

import java.util.Date;

public interface CommentforUserInterface {
    public Integer getComment_Id();
    public Integer getShop_Id();
    public String getShop_Name();
    public String getAvatar();
    public String getContent();
    public Date getComment_Time();
}
