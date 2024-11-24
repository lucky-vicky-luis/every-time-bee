package com.project.everytime.domain.posts.application;

import com.project.everytime.domain.posts.payload.request.PostDeleteRequest;
import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.request.PostSearchRequest;
import com.project.everytime.domain.posts.payload.request.PostUpdateRequest;
import com.project.everytime.global.common.BaseResponse;
import org.springframework.security.core.Authentication;


public interface PostService {

    BaseResponse findAll();

    BaseResponse myPosts(Long userId, Authentication authentication);

    BaseResponse createPost(PostDto postDto);

    BaseResponse readPost(Long id);

    BaseResponse postSearch(PostSearchRequest request);

    BaseResponse addLike(Long postId);

    BaseResponse deletePost(PostDeleteRequest postDeleteRequest, Authentication authentication);

    BaseResponse updatePost(Long postId, PostUpdateRequest postUpdateRequest);

}
