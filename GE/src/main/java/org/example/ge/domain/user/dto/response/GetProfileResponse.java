package org.example.ge.domain.user.dto.response;

public record GetProfileResponse (
        String nickname,
        int userRank,
        Long target,
        String profile
) {
}
