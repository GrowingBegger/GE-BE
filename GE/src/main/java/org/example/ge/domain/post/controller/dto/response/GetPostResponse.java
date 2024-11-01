package org.example.ge.domain.post.controller.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record GetPostResponse(
        Long postId,
        String title,
        BigDecimal price,
        String imageUrl,
        String content,
        LocalDateTime createdAt,
        String writerName,
        String writerImageUrl
) {
}
