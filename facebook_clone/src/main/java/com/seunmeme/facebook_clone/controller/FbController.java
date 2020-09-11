package com.seunmeme.facebook_clone.controller;

import com.seunmeme.facebook_clone.model.Comment;
import com.seunmeme.facebook_clone.model.LikePost;
import com.seunmeme.facebook_clone.model.Post;
import com.seunmeme.facebook_clone.model.User;
import com.seunmeme.facebook_clone.service.CommentService;
import com.seunmeme.facebook_clone.service.LikePostService;
import com.seunmeme.facebook_clone.service.PostService;
import com.seunmeme.facebook_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class FbController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikePostService likePostService;


//Route for landing page
    @GetMapping("/")
    public String viewHomePage(Model model){

//        Set user so it can be accessed by login and register form
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

//    Route for adding post
    @PostMapping("/addPost")
    public String addPost(Post post, HttpSession session) {
        User user = (User)session.getAttribute("user");

        post.setUser(user);
        postService.addPost(post);
        return "redirect:/home";

    }

    //    Route for updating a post
    @PostMapping("/updatePost/{postId}")
    public String updatePost(HttpSession session, @PathVariable String postId, @RequestParam(value = "content") String content) {
        User user = (User)session.getAttribute("user");
        Post thePost = postService.getPostById(Long.parseLong(postId));

        thePost.setContent(content);
        thePost.setUser(user);
        postService.addPost(thePost);
        return "redirect:/home";

    }

    //    Route for deleting a post
    @GetMapping("/delete/{postId}")
    public String deletePost(@PathVariable String postId) {
        Post post = postService.getPostById(Long.parseLong(postId));

        postService.deletePost(post);
        return "redirect:/home";

    }

//    Route for adding comment
    @PostMapping(value="/addComment/{postId}")
    public String addComment(Comment comment, HttpSession session, @PathVariable String postId) {
        User user = (User)session.getAttribute("user");

        Post post = postService.getPostById(Long.parseLong(postId));

        comment.setUser(user);
        comment.setPost(post);
        commentService.addComment(comment);
        return "redirect:/home";

    }

    //    Route for liking a post
    @GetMapping(value="/likePost/{postId}")
    public String likePost(LikePost likePost, HttpSession session, @PathVariable String postId) {
        User user = (User)session.getAttribute("user");

        Post post = postService.getPostById(Long.parseLong(postId));

        likePost.setUser(user);
        likePost.setPost(post);
       likePostService.addLike(likePost);
        return "redirect:/home";

    }

    //    Route for deleting a like on a post
    @GetMapping(value="/likePost/delete/{postId}")
    public String deletePostLike(HttpSession session, @PathVariable String postId) {
        Post post = postService.getPostById(Long.parseLong(postId));

        likePostService.deleteLike(post, session);

        return "redirect:/home";

    }

}
