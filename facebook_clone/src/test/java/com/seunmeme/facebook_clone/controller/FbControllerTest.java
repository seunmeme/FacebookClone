package com.seunmeme.facebook_clone.controller;

import com.seunmeme.facebook_clone.model.Post;
import com.seunmeme.facebook_clone.model.User;
import com.seunmeme.facebook_clone.repository.PostRepository;
import com.seunmeme.facebook_clone.repository.UserRepository;
import com.seunmeme.facebook_clone.service.PostService;
import com.seunmeme.facebook_clone.service.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FbControllerTest {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PostService postService;



    @MockBean
    UserRepository userRepository;

    @MockBean
    PostRepository postRepository;

    @Test
    void viewDashboard() {
//        User user = new User(1, "Seyi", "Badu", "set@eg.com", "command", "14/10/2341", "Male");
//
//        when(postRepository.findAll())
//                .thenReturn((Stream.of(new Post(1, "hello there!", LocalDateTime.now(), user),
//                        new Post(2, "Say there!", LocalDateTime.now(), user)).collect(Collectors.toList())));
//
//        int actual = Stream.of(postService.getPosts()).collect(Collectors.toList()).size();
//        assertEquals(2, actual);
    }

    @Test
    void viewHomePage() {
    }

    @Test
    void addUser() {
    }

    @Test
    void login() {
    }

    @Test
    void addPost() {
    }

    @Test
    void addComment() {
    }
}