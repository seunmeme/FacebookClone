package com.seunmeme.facebook_clone.service.serviceImpl;

import com.seunmeme.facebook_clone.model.Post;
import com.seunmeme.facebook_clone.repository.PostRepository;
import com.seunmeme.facebook_clone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id){
        return postRepository.findPostById(id);
    }



}
