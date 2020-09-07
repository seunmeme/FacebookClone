package com.seunmeme.facebook_clone.repository;

import com.seunmeme.facebook_clone.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
