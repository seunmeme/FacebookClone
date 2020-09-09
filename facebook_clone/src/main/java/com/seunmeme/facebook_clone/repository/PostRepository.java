package com.seunmeme.facebook_clone.repository;

import com.seunmeme.facebook_clone.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findPostById(Long id);
}
