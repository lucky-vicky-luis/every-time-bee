package com.project.everytime.domain.posts.application;

import com.project.everytime.domain.posts.application.exception.PostError;
import com.project.everytime.domain.posts.domain.Post;
import com.project.everytime.domain.posts.domain.repository.PostQueryRepository;
import com.project.everytime.domain.posts.domain.repository.PostRepository;
import com.project.everytime.domain.posts.application.exception.PostException;
import com.project.everytime.domain.posts.mapper.PostMapper;
import com.project.everytime.domain.posts.payload.request.PostDeleteRequest;
import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.request.PostSearchRequest;
import com.project.everytime.domain.posts.payload.response.PostResponseDto;
import com.project.everytime.domain.user.domain.entity.UserEntity;
import com.project.everytime.domain.user.domain.repository.UserRepository;
import com.project.everytime.domain.user.exception.UserException;
import com.project.everytime.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    @Override
    @Transactional(readOnly = true)
    public BaseResponse findAll() {
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<PostResponseDto> dtos = postMapper.convertPostsToDtos(posts);
        return BaseResponse.ok("모든 게시글 불러오기 성공", dtos);
    }

    @Override
    public BaseResponse myPosts(Long userId, Authentication authentication) {
        UserEntity user = findUserByUserId(userId);
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<PostResponseDto> dtos = postMapper.convertPostsToDtos(posts);
        return BaseResponse.ok("해당 유저의 게시글 불러오기 성공", dtos);
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
    public BaseResponse postSearch(PostSearchRequest request) {
        return BaseResponse.ok("조회 성공",postQueryRepository.postSearch(request));
    }

    @Transactional
    public BaseResponse deletePost(PostDeleteRequest postDeleteRequest, Authentication authentication) {
        UserEntity user = findUserById(postDeleteRequest.writerId());
        deletePostById(postDeleteRequest.postId());
        return new BaseResponse(HttpStatus.OK, "게시글 삭제 성공");
    }

    @Transactional(readOnly = true)
    public UserEntity findUserByUserId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(UserException::notFoundUser);
    }

    private UserEntity findUserById(Long writerId) {
        return userRepository.findById(writerId)
                .orElseThrow(UserException::notFoundUser);
    }

    private void deletePostById(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostException(PostError.POST_NOT_FOUND_EXCEPTION);
        }
        postRepository.deleteById(id);
    }

}
