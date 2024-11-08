package org.example.ge.domain.post.dto.response.postDetail;

import java.time.LocalDateTime;

public record CommentDto(
        String content,
        LocalDateTime createdAt,
        UserDto user
) {
}
