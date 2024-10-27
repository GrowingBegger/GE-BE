package org.example.ge.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.EditProfileImgRequest;
import org.example.ge.domain.user.dto.request.EditProfileInfoRequest;
import org.example.ge.domain.user.dto.request.LoginRequest;
import org.example.ge.domain.user.dto.request.SignupRequest;
import org.example.ge.domain.user.dto.response.GetProfileResponse;
import org.example.ge.domain.user.dto.response.LoginResponse;
import org.example.ge.domain.user.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final LoginService loginService;
    private final SignupService signupService;
    private final GetUserProfileService getProfileService;
    private final EditProfileImgService editProfileImgService;
    private final EditProfileInfoService editProfileInfoService;

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

    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    public GetProfileResponse getProfile() {
        return getProfileService.execute();
    }

    @PatchMapping("/img")
    @ResponseStatus(HttpStatus.OK)
    public void editProfileImg(@ModelAttribute EditProfileImgRequest editProfileImgRequest) {
        editProfileImgService.execute(editProfileImgRequest);
    }

    @PatchMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public void editProfileInfo(@RequestBody EditProfileInfoRequest editProfileInfoRequest) {
        editProfileInfoService.execute(editProfileInfoRequest);
    }
}
