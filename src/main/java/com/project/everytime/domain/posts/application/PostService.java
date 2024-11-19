package com.project.everytime.domain.posts.application;

import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.global.common.BaseResponse;

public interface PostService {

    BaseResponse findAll();

    BaseResponse createPost(PostDto postDto);

    BaseResponse readPost(Long id);

}
