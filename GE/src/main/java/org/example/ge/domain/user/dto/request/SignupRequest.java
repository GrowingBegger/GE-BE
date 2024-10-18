package org.example.ge.domain.user.dto.request;

import jakarta.persistence.Column;

public record SignupRequest(
        String username,
        String nickname,
        String password,
        Long target
) {
}