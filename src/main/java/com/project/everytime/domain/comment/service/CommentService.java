package com.project.everytime.domain.comment.service;

import com.project.everytime.domain.comment.client.dto.CommentDto;
import com.project.everytime.domain.comment.client.dto.request.CommentRegisterRequest;
import com.project.everytime.domain.comment.domain.entity.Comment;
import com.project.everytime.domain.comment.domain.repository.CommentRepository;
import com.project.everytime.domain.posts.domain.Post;
import com.project.everytime.domain.posts.domain.repository.PostRepository;
import com.project.everytime.domain.posts.exception.PostNotFoundException;
import com.project.everytime.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public BaseResponse createComment(CommentRegisterRequest request){
        Post post = getPost(request.postId());
        commentRepository.save(Comment.builder()
                        .content(request.content())
                        .userId(request.userId())
                        .postId(post.getId())
                .build());
        return BaseResponse.created("생성 성공");
    }

    public BaseResponse deleteComment(Long commentId){
        Comment comment = commentRepository.
                findById(commentId)
                .orElseThrow(PostNotFoundException::new);
        commentRepository.deleteById(comment.getId());
        return BaseResponse.created("삭제 성공");
    }

    public BaseResponse getComments(Long postId){
        Post post = getPost(postId);
        return BaseResponse.ok("조회 성공", commentRepository.findAllByPostId(post.getId()));
    }

    public Post getPost(Long postId){
        return postRepository
                .findById(postId)
                .orElseThrow(PostNotFoundException::new);
    }

}
