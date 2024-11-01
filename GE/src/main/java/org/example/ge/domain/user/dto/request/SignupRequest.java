package org.example.ge.domain.user.dto.request;

public record SignupRequest(
        String username,
        String nickname,
        String password,
        Long target
) {
}
