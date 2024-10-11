package org.example.ge.domain.user.dto.request;

public record LoginRequestDto (
        String nickname,
        String password
) {
}
