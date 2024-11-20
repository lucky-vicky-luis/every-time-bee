package com.project.everytime.domain.posts.application;

import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.request.PostSearchRequest;
import com.project.everytime.global.common.BaseResponse;
import java.util.List;

public interface PostService {

    BaseResponse findAll();

    BaseResponse createPost(PostDto postDto);

    BaseResponse readPost(Long id);

    List<PostDto> postSearch(PostSearchRequest request);
}
