package com.seunmeme.facebook_clone.repository;

import com.seunmeme.facebook_clone.model.LikePost;
import com.seunmeme.facebook_clone.model.Post;
import com.seunmeme.facebook_clone.model.User;
import org.springframework.data.repository.CrudRepository;

public interface LikePostRepository extends CrudRepository<LikePost, Long> {
    public boolean existsByUser(User user);
    public LikePost getLikePostByPost(Post post);
    public void deleteByPost(Post post);

}
