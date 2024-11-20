package com.project.everytime.domain.posts.application;

import com.project.everytime.domain.posts.domain.Post;
import com.project.everytime.domain.posts.domain.repository.PostQueryRepository;
import com.project.everytime.domain.posts.domain.repository.PostRepository;
import com.project.everytime.domain.posts.application.exception.PostException;
import com.project.everytime.domain.posts.mapper.PostMapper;
import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.request.PostSearchRequest;
import com.project.everytime.domain.posts.payload.response.PostResponseDto;
import com.project.everytime.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;
    private final PostMapper postMapper;

    @Override
    @Transactional(readOnly = true)
    public BaseResponse findAll() {
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<PostResponseDto> dtos = postMapper.convertPostsToDtos(posts);
        return BaseResponse.ok("모든 게시글 불러오기 성공", dtos);
    }

    @Override
    @Transactional
    public BaseResponse createPost(PostDto postDto) {
        postRepository.save(postMapper.dtoToEntity(postDto));
        return BaseResponse.created("게시글 생성 성공");
    }

    @Override
    @Transactional(readOnly = true)
    public BaseResponse readPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostException::notFoundPost);
        return BaseResponse.ok("게시글 단일 조회 성공", postMapper.entityToDto(post));
    }

    @Override
    public List<PostDto> postSearch(PostSearchRequest request) {
        return postQueryRepository.roomSearch(request);
    }

}
