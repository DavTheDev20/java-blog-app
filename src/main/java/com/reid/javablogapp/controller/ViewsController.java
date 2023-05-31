package com.reid.javablogapp.controller;

import com.reid.javablogapp.model.Post;
import com.reid.javablogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewsController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String root(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/post/{id}")
    public String postPage(@PathVariable("id") long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post";
    }
}
