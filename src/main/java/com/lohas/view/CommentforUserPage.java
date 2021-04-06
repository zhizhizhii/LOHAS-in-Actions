package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.dao.inter.CommentforUserInterface;
import com.lohas.dao.inter.UserCommentInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentforUserPage extends PaginationReceive {
    @ApiModelProperty(value = "评论列表")
    @JsonProperty("commentitemlist")
    private List<CommentforUserItem> commentItemList;


    public CommentforUserPage(Page<CommentforUserInterface> userCommentPage){
        setPageNum(userCommentPage.getNumber() + 1);
        setTotalPage(userCommentPage.getTotalPages());

        List<CommentforUserItem> list = new ArrayList<>();
        for(CommentforUserInterface item : userCommentPage){
            CommentforUserItem c = new CommentforUserItem();
            c.setShopId(item.getShop_Id());
            c.setCommentId(item.getComment_Id());
            c.setContent(item.getContent());
            c.setShopName(item.getShop_Name());
            c.setCommentTime(item.getComment_Time());
            c.setAvatar(item.getAvatar());
            list.add(c);
        }
        setCommentItemList(list);
    }
}
