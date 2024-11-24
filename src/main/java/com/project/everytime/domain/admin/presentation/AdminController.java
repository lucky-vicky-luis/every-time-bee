package com.project.everytime.domain.admin.presentation;

import com.project.everytime.domain.posts.application.PostService;
import com.project.everytime.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PostService postService;

    @GetMapping("/list")
    public BaseResponse allPosts(){
        return postService.findAll();
    }
}
