package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.dao.inter.UserCommentInterface;
import com.lohas.model.ShopInfo;
import com.lohas.model.UserComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentPage extends PaginationReceive {

    @ApiModelProperty(value = "评论列表")
    @JsonProperty("comment_item_list")
    private List<CommentItem> commentItemList;

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
            c.setCommentTime(item.getComment_Time());
            c.setAvatar(item.getAvatar());
            list.add(c);
        }
        setCommentItemList(list);
    }
}
