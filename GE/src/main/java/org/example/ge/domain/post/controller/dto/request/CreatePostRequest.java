package org.example.ge.domain.post.controller.dto.request;

import org.example.ge.domain.post.entity.Post;

import java.math.BigDecimal;

public record CreatePostRequest(
        String title,
        String content,
        BigDecimal price
) {
    public Post toEntity(Long userId, String imageUrl) {
        return Post.builder()
                .title(title)
                .content(content)
                .price(price)
                .userId(userId)
                .imageUrl(imageUrl)
                .build();
    }
}
