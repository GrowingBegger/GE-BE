package org.example.ge.domain.user.useCase;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.LoginRequestDto;
import org.example.ge.domain.user.dto.response.LoginResponseDto;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.PasswordMismatches;
import org.example.ge.domain.user.service.LoginService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final LoginService loginService;

    public LoginResponseDto execute (LoginRequestDto requestDto) {
        User user = loginService.getUserById(requestDto.username());

        if (!loginService.checkPasswordMatches(requestDto.password(), user.getPassword())) {
            throw PasswordMismatches.EXCEPTION;
        }

        return loginService.generateTokens(user.getUserId());
    }
}
