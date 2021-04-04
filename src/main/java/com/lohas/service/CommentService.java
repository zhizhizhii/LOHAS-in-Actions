package com.lohas.service;

import com.lohas.dao.ShopDAO;
import com.lohas.dao.UserCommentDAO;
import com.lohas.dao.UserDAO;
import com.lohas.exception.AnnouncementDoesNotExistException;
import com.lohas.model.*;
import com.lohas.request.*;
import com.lohas.utils.JWTUtils;
import com.lohas.view.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
@Service
public class CommentService {

    @Autowired
    UserCommentDAO userCommentDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    ShopDAO shopDAO;

    public Status createComment(CreateCommentRequest createCommentRequest, HttpServletRequest request){
        Status status = new Status();
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        try{
            User user = userDAO.findUserByUserId(userId);
            Shop shop = shopDAO.findShopByShopId(createCommentRequest.getShopId());
            UserComment userComment = new UserComment();
            userComment.setContent(createCommentRequest.getContent());
            userComment.setShop(shop);
            userComment.setUser(user);
            userComment.setCommentTime(new Date());
            userCommentDAO.save(userComment);
            status.setState(true);
            status.setMsg("添加成功");
        }
        catch (Exception e){
            status.setState(false);
            status.setMsg("添加失败");
        }
        return status;
    }

    public Status updateComment(UpdateCommentRequest updateCommentRequest, HttpServletRequest request){
        Status status = new Status();
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        try {
            UserComment userComment = userCommentDAO.findByCommentId(updateCommentRequest.getCommentId());
            if(userComment==null || !userComment.getUser().getUserId().equals(userId)){
                throw new AnnouncementDoesNotExistException();
            }
            userComment.setCommentTime(new Date());
            userComment.setContent(updateCommentRequest.getContent());
            userCommentDAO.save(userComment);
            status.setState(true);
            status.setMsg("更新成功");
        } catch (AnnouncementDoesNotExistException e) {
            status.setState(false);
            status.setMsg("更新失败");
        }
        return status;
    }

    public Status deleteComment(DeleteCommentRequest deleteCommentRequest, HttpServletRequest request){
        Status status =new Status();
        Integer userId = Integer.valueOf(JWTUtils.getTokenInfo(request.getHeader("token")).getClaim("user_id").asString());
        try {
            UserComment userComment = userCommentDAO.findByCommentId(deleteCommentRequest.getCommentId());
            if(userComment==null || !userComment.getUser().getUserId().equals(userId)){
                throw new AnnouncementDoesNotExistException();
            }
            userCommentDAO.delete(userComment);
            status.setState(true);
            status.setMsg("删除成功");
        } catch (AnnouncementDoesNotExistException e) {
            status.setState(false);
            status.setMsg("删除失败");
        }
        return status;
    }


}
