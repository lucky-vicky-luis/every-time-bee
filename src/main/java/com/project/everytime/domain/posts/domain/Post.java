package com.project.everytime.domain.posts.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime regDate;

    @Column(nullable = false)
    private Long likeCount;

    @Column(nullable = false)
    private boolean public_status;

    @Builder
    public Post(String title, String content, LocalDateTime regDate, Long likeCount, boolean public_status) {
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.likeCount = likeCount;
        this.public_status = public_status;
    }

}
