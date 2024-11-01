package org.example.ge.domain.post.controller.dto.response;

public record CreatePostResponse(
        Long id
) {
    public CreatePostResponse {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
    }
}
