package org.example.ge.domain.post.controller.dto.request;

import java.math.BigDecimal;

public record CreatePostRequest(
        String title,
        String content,
        BigDecimal price
) {
}
