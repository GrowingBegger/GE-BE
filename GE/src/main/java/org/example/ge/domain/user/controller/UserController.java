package org.example.ge.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.LoginRequest;
import org.example.ge.domain.user.dto.request.SignupRequest;
import org.example.ge.domain.user.dto.response.LoginResponse;
import org.example.ge.domain.user.service.LoginService;
import org.example.ge.domain.user.service.SignupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final LoginService loginService;
    private final SignupService signupService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest requestDto) {
        return loginService.execute(requestDto);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse signup(@RequestBody SignupRequest signupRequest) {
        return signupService.execute(signupRequest);
    }
}
