package com.project.everytime.domain.posts.presentation;

import com.project.everytime.domain.posts.application.PostService;
import com.project.everytime.domain.posts.payload.request.PostDeleteRequest;
import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.request.PostSearchRequest;
import com.project.everytime.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
        return postService.postSearch(request);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deletePost(@RequestBody PostDeleteRequest postDeleteRequest, Authentication authentication){
        return postService.deletePost(postDeleteRequest, authentication);

    }

    @PatchMapping
    public BaseResponse addLike(@RequestParam Long postId){
        return postService.addLike(postId);
    }

}