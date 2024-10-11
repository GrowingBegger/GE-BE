package org.example.ge.domain.user.dto.request;

public record LoginRequestDto (
        String username,
        String password
) {
}
