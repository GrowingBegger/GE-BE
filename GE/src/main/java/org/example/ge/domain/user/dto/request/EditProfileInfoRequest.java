package org.example.ge.domain.user.dto.request;

import java.util.Optional;

public record EditProfileInfoRequest (
        String nickname,
        Long target
) {
}
