package com.project.everytime.domain.posts.presentation;

import com.project.everytime.domain.posts.application.PostService;
import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.request.PostSearchRequest;
import com.project.everytime.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public BaseResponse allPosts(){
        return postService.findAll();
    }

    @PostMapping("/create")
    public BaseResponse createPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @GetMapping("/detail/{id}")
    public BaseResponse readPost(@PathVariable("id") Long id){
        return postService.readPost(id);
    }

    @GetMapping("/search")
    public BaseResponse searchPost(@RequestBody PostSearchRequest request){
        return BaseResponse.ok(
                "조회성공",
                postService.postSearch(request));
    }

}
