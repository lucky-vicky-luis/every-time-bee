package com.project.everytime.domain.posts.application;

import com.project.everytime.domain.posts.payload.request.PostDeleteRequest;
import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.global.common.BaseResponse;
import org.springframework.security.core.Authentication;

public interface PostService {

    BaseResponse findAll();

    BaseResponse createPost(PostDto postDto);

    BaseResponse readPost(Long id);

    BaseResponse deletePost(PostDeleteRequest postDeleteRequest, Authentication authentication);

}
