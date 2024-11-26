package com.project.everytime.domain.posts.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@Table(name = "tb_post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private boolean publicStatus;

    @Column(nullable = false)
    private Long writerId;

}
