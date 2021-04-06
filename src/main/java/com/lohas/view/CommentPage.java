package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.dao.inter.UserCommentInterface;
import com.lohas.model.ShopInfo;
import com.lohas.model.UserComment;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class CommentPage extends PaginationReceive {
    @ApiModelProperty(value = "评论列表")
    @JsonProperty("commentitemlist")
    private List<CommentItem> commentItemList;

    public List<CommentItem> getCommentItemList() {
        return commentItemList;
    }

    public void setCommentItemList(List<CommentItem> commentItemList) {
        this.commentItemList = commentItemList;
    }

    public CommentPage(Page<UserCommentInterface> userCommentPage){
        setPageNum(userCommentPage.getNumber() + 1);
        setTotalPage(userCommentPage.getTotalPages());

        List<CommentItem> list = new ArrayList<>();
        for(UserCommentInterface item : userCommentPage){
            CommentItem c = new CommentItem();
            c.setUserId(item.getUser_Id());
            c.setCommentId(item.getComment_Id());
            c.setContent(item.getContent());
            c.setUserName(item.getUser_Name());
            System.out.println(item.getComment_Time());
            c.setCommentTime(item.getComment_Time());
            c.setAvatar(item.getAvatar());
            list.add(c);
        }
        setCommentItemList(list);
    }
}
