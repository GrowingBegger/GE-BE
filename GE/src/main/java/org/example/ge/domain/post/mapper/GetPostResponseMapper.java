package org.example.ge.domain.post.mapper;

import org.example.ge.domain.post.controller.dto.response.GetPostResponse;
import org.example.ge.domain.post.entity.Post;
import org.example.ge.domain.user.entity.User;
import org.example.ge.instrastructure.common.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class GetPostResponseMapper implements Mapper<GetPostResponse, Post, User> {

    @Override
    public Post toEntity(GetPostResponse dto, User params) {
        return null;
    }

    @Override
    public GetPostResponse toDto(Post entity, User params) {
        return GetPostResponse.builder()
                .postId(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .price(entity.getPrice())
                .imageUrl(entity.getImageUrl())
                .writerImageUrl(params.getProfile())
                .build();
    }
}
