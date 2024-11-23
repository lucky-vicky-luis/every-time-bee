package com.project.everytime.domain.comment.domain.repository;

import com.project.everytime.domain.comment.domain.entity.Comment;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Transactional(rollbackOn = Exception.class)
    void deleteById(Long commentId);
    List<Comment> findAllByPostId(Long postId);
}
