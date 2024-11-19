package com.project.everytime.domain.posts.domain.repository;

import com.project.everytime.domain.posts.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
