package com.seunmeme.facebook_clone.service.serviceImpl;

import com.seunmeme.facebook_clone.model.Comment;
import com.seunmeme.facebook_clone.repository.CommentRepository;
import com.seunmeme.facebook_clone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
