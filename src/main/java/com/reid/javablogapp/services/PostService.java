package com.reid.javablogapp.services;

import com.reid.javablogapp.model.Post;
import com.reid.javablogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        }
        return null;
    }

    public Post updatePostById(long id, Post post) {
        Optional<Post> post1 = postRepository.findById(id);

        if (post1.isPresent()) {
            Post originalPost = post1.get();
            if (Objects.nonNull(originalPost.getTitle()) && !"".equalsIgnoreCase(originalPost.getTitle())) {
                originalPost.setTitle(post.getTitle());
            }
            if (Objects.nonNull(originalPost.getContent()) && !"".equalsIgnoreCase(originalPost.getContent())) {
                originalPost.setContent(post.getContent());
            }
            return postRepository.save(originalPost);
        }
        return null;
    }

    public String deletePostById(long id) {
        if (postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
            return "Successfully deleted post " + id;
        }
        return "Post not found";
    }

}
