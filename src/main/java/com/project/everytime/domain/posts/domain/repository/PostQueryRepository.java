package com.project.everytime.domain.posts.domain.repository;

import static com.project.everytime.domain.posts.domain.QPost.post;

import com.project.everytime.domain.posts.payload.request.PostDto;
import com.project.everytime.domain.posts.payload.request.PostSearchRequest;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<PostDto> postSearch(PostSearchRequest request){
        return jpaQueryFactory
                .select(roomConstructorExpression())
                .from(post)
                .where(post.title.contains(request.getTitle()))
                .offset((long) (request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(post.id.desc())
                .fetch();
    }

    private ConstructorExpression<PostDto> roomConstructorExpression(){
        return Projections.constructor(PostDto.class,
                post.id,
                post.title,
                post.content,
                post.regDate,
                post.likeCount,
                post.public_status
        );
    }

}
