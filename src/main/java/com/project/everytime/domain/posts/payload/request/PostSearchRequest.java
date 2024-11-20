package com.project.everytime.domain.posts.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearchRequest {

    private int page;
    private int size;
    private String title;

}