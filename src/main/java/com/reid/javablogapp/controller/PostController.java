package com.reid.javablogapp.controller;

import com.reid.javablogapp.model.Post;
import com.reid.javablogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/api/posts")
    public Post addPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/api/posts/{id}")
    public Post getPostById(@PathVariable("id") long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable("id") long id, Post post) {
        return postService.updatePostById(id, post);
    }

    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable("id") long id) {
        return postService.deletePostById(id);
    }

}
