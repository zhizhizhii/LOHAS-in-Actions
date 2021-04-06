package com.lohas.dao.inter;

import java.util.Date;

public interface UserCommentInterface {
    Integer getUser_Id();
    Integer getComment_Id();
    String getUser_Name();
    String getAvatar();
    String getContent();
    Date getComment_Time();
}
