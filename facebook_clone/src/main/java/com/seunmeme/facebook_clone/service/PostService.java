package com.seunmeme.facebook_clone.service;

import com.seunmeme.facebook_clone.model.Post;

public interface PostService {
    public void addPost(Post post);

    public Iterable<Post> getPosts();
}
