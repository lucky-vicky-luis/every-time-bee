package com.project.everytime.domain.posts.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearchRequest {
    private int page;
    private int size;
    @NotBlank
    private String title;

}