package org.example.ge.domain.user.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
