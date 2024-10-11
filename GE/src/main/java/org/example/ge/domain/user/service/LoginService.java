package org.example.ge.domain.user.service;

import org.example.ge.domain.user.dto.response.LoginResponseDto;
import org.example.ge.domain.user.entity.User;

public interface LoginService {
    User getUserById (String username);

    Boolean checkPasswordMatches (String rawPassword, String encryptedPassword);

    LoginResponseDto generateTokens (Long userId);
}
