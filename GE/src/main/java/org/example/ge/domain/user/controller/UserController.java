package org.example.ge.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.LoginRequest;
import org.example.ge.domain.user.dto.response.LoginResponse;
import org.example.ge.domain.user.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final LoginService loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(LoginRequest requestDto) {
        return loginService.execute(requestDto);
    }
}
