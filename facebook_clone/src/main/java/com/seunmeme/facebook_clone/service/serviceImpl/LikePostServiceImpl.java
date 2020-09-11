package com.seunmeme.facebook_clone.service.serviceImpl;

import com.seunmeme.facebook_clone.model.LikePost;
import com.seunmeme.facebook_clone.model.Post;
import com.seunmeme.facebook_clone.model.User;
import com.seunmeme.facebook_clone.repository.LikePostRepository;
import com.seunmeme.facebook_clone.service.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LikePostServiceImpl implements LikePostService {

    @Autowired
    LikePostRepository likePostRepository;

    @Override
    public void addLike(LikePost likePost) {
        likePostRepository.save(likePost);
    }

    public void deleteLike(Post post, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(likePostRepository.existsByUser(user)){
            likePostRepository.deleteByPost(post);
        }
    }
}
