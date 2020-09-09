package com.seunmeme.facebook_clone.controller;

import com.seunmeme.facebook_clone.model.Comment;
import com.seunmeme.facebook_clone.model.Post;
import com.seunmeme.facebook_clone.model.User;
import com.seunmeme.facebook_clone.service.PostService;
import com.seunmeme.facebook_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.stream.Stream;



@Controller
public class FbController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    @GetMapping("/home")
    public String viewDashboard(Model model){
        Post post = new Post();
        Iterable<Post> posts = postService.getPosts();
//        add posts to the model
        model.addAttribute("posts", posts);
        model.addAttribute("post", post);
        Stream.of(posts).forEach(p -> System.out.println(p));
        return "dashboard";
    }


    @GetMapping("/")
    public String viewHomePage(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "index";
    }


    @PostMapping("/register")
    public String addUser(User user, HttpSession session) {
        User theUser = userService.findByEmail(user.getEmail());
//        if the user already exists, return to home page
        if(theUser != null){
            return "redirect:/";
        }else{
            userService.register(user);
            session.setAttribute("user", userService.findByEmail(user.getEmail()));
            return "redirect:/home";
        }

    }


    @PostMapping("/login")
    public String login(User user, HttpSession session){
        try {
            User checkUser = userService.findByEmail(user.getEmail());
            if(checkUser.getPassword().equals(user.getPassword()) ){
                session.setAttribute("user", checkUser);
            }
        }catch(Exception ex){
            return "redirect:/";
        }
        return "redirect:/home";
    }

    @PostMapping("/addPost")
    public String addPost(Post post, HttpSession session) {
        User user = (User)session.getAttribute("user");

        post.setUser(user);
        postService.addPost(post);
        return "redirect:/home";

    }

    @PostMapping("/comment")
    public String addComment(Comment comment, Post post, HttpSession session) {
        User user = (User)session.getAttribute("user");
        post.setContent("hello");
        comment.setUser(user);
        comment.setPost(post);
        postService.addPost(post);
        return "redirect:/home";

    }
}
