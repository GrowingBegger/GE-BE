package org.example.ge.domain.post.mapper;


import org.example.ge.domain.post.controller.dto.request.CreatePostRequest;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.instrastructure.common.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CreatePostRequestMapper implements Mapper<CreatePostRequest, Post, CreatePostParams> {
    @Override
    public Post toEntity(CreatePostRequest request, CreatePostParams params) {
        return Post.builder()
                .title(request.title())
                .content(request.content())
                .price(request.price())
                .userId(params.userId())
                .imageUrl(params.imageUrl())
                .build();
    }
}