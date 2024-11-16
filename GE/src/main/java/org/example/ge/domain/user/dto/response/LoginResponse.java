package org.example.ge.domain.user.dto.response;

public record LoginResponse(
        String accessToken,

        String nickname
) {
}
