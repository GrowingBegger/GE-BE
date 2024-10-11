package org.example.ge.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.LoginRequestDto;
import org.example.ge.domain.user.dto.response.LoginResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public LoginResponseDto login(LoginRequestDto requestDto) {
        return null;
    }
}
