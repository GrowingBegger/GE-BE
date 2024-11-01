package org.example.ge.domain.post.mapper;

import org.example.ge.domain.post.controller.dto.request.UpdatePostRequest;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.instrastructure.common.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostRequestMapper implements Mapper<UpdatePostRequest, Post, UpdatePostParams> {
    @Override
    public Post toEntity(UpdatePostRequest request, UpdatePostParams params) {
        return Post.builder()
                .id(params.postId())
                .title(request.title())
                .content(request.content())
                .price(request.price())
                .imageUrl(params.imageUrl())
                .build();
    }

    @Override
    public UpdatePostRequest toDto(Post entity, UpdatePostParams params) {
        return null;
    }
}
