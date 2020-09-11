package com.seunmeme.facebook_clone.service;

import com.seunmeme.facebook_clone.model.Comment;
import com.seunmeme.facebook_clone.model.LikePost;
import com.seunmeme.facebook_clone.model.Post;

import javax.servlet.http.HttpSession;

public interface LikePostService {
    public void addLike(LikePost likePost);

    public void deleteLike(Post post, HttpSession session);
}
