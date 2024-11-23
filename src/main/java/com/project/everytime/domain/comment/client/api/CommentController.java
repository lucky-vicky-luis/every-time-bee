package com.project.everytime.domain.comment.client.api;

import com.project.everytime.domain.comment.client.dto.request.CommentRegisterRequest;
import com.project.everytime.domain.comment.service.CommentService;
import com.project.everytime.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public BaseResponse registerComment(@RequestBody CommentRegisterRequest request) {
        return commentService.createComment(request);
    }

    @GetMapping
    public BaseResponse getComments(@RequestParam Long postId) {
        return commentService.getComments(postId);
    }

    @DeleteMapping
    public BaseResponse deleteComment(@RequestParam Long commentId) {
        return commentService.deleteComment(commentId);
    }

}