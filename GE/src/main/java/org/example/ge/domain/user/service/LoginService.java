package org.example.ge.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.LoginRequest;
import org.example.ge.domain.user.dto.response.LoginResponse;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.PasswordMismatches;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.example.ge.instrastructure.security.jwt.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserJpaRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;

    public LoginResponse execute (LoginRequest requestDto) {
        User user = userRepository.getUserByUsername(requestDto.username()).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );

        if (!bCryptPasswordEncoder.matches(requestDto.password(), user.getPassword())) {
            throw PasswordMismatches.EXCEPTION;
        }

        return new LoginResponse(jwtService.generateAccess(user.getUserId()), user.getNickname());
    }
}
