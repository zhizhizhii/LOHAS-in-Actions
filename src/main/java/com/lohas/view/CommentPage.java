package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.model.UserComment;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

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

    public CommentPage(Page<UserComment> userCommentPage){
        setPageNum(userCommentPage.getNumber() + 1);
        setTotalPage(userCommentPage.getTotalPages());
        //TODO:序列化
    }
}
