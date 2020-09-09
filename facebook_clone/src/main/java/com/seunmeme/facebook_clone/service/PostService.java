package com.seunmeme.facebook_clone.service;

import com.seunmeme.facebook_clone.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface PostService {
    public void addPost(Post post);

    public Post getPostById(Long id);

    public Iterable<Post> getPosts();
}
