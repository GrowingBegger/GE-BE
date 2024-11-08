package org.example.ge.domain.post.dto.response.postDetail;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PostDto(
        Long id,
        String title,
        String image_url,
        BigDecimal price,
        LocalDateTime created_at,
        UserDto user
) {
}
