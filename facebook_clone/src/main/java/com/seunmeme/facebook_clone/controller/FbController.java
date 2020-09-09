package com.seunmeme.facebook_clone.controller;

import com.seunmeme.facebook_clone.model.Comment;
import com.seunmeme.facebook_clone.model.Post;
import com.seunmeme.facebook_clone.model.User;
import com.seunmeme.facebook_clone.service.CommentService;
import com.seunmeme.facebook_clone.service.PostService;
import com.seunmeme.facebook_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FbController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;


//    Route for showing dashboard
    @GetMapping("/home")
    public String viewDashboard(Model model){
        Post post = new Post();
        Comment comment = new Comment();
        Iterable<Post> posts = postService.getPosts();
//        add posts to the model
        model.addAttribute("posts", posts);
        model.addAttribute("post", post);
        model.addAttribute("comment", comment);

        return "dashboard";
    }

//Route for landing page
    @GetMapping("/")
    public String viewHomePage(Model model){
        User user = new User();
        model.addAttribute("user", user);

        return "index";
    }

// Route for registration
    @PostMapping("/register")
    public String addUser(User user, HttpSession session) {
        User theUser = userService.findByEmail(user.getEmail());
//        if the user already exists, return to home page
        if(userService.existsByEmail(user.getEmail())){
            return "redirect:/";
        }else{
            userService.register(user);
            session.setAttribute("user", userService.findByEmail(user.getEmail()));
            return "redirect:/home";
        }

    }

//Route for user login
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

//    Route for adding post
    @PostMapping("/addPost")
    public String addPost(Post post, HttpSession session) {
        User user = (User)session.getAttribute("user");

        post.setUser(user);
        postService.addPost(post);
        return "redirect:/home";

    }

//    Route for adding comment
    @PostMapping(value="/addComment/{postId}")
    public String addComment(Comment comment, HttpSession session, @PathVariable String postId) {
        System.out.println(postId);
        User user = (User)session.getAttribute("user");
        System.out.println(user);

        Post post = postService.getPostById(Long.parseLong(postId));
        System.out.println(postId);
        System.out.println(post);

        comment.setUser(user);
        comment.setPost(post);
        commentService.addComment(comment);
        return "redirect:/home";

    }
}
