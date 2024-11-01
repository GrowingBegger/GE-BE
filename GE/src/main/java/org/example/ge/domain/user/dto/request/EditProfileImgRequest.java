package org.example.ge.domain.user.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record EditProfileImgRequest (
        MultipartFile profile
) {
}
