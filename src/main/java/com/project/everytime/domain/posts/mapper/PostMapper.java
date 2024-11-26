package com.project.everytime.domain.posts.mapper;

import com.project.everytime.domain.posts.domain.Post;
import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.response.PostResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public PostResponseDto entityToDto(Post entity) {
        return PostResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .likeCount(entity.getLikeCount())
                .publicStatus(entity.isPublicStatus())
                .writerId(entity.getWriterId())
                .build();
    }

    public Post dtoToEntity(PostDto dto) {
        return Post.builder()
                .title(dto.title())
                .content(dto.content())
                .regDate(LocalDateTime.now())
                .likeCount(dto.likeCount())
                .publicStatus(dto.publicStatus())
                .writerId(dto.writerId())
                .build();
    }

    public List<PostResponseDto> convertPostsToDtos(List<Post> posts) {
        return posts.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

}
