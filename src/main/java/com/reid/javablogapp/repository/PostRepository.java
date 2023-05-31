package com.reid.javablogapp.repository;

import com.reid.javablogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
