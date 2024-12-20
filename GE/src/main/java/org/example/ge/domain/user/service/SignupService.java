package org.example.ge.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.rating.entity.Rating;
import org.example.ge.domain.rating.repository.RatingRepository;
import org.example.ge.domain.user.dto.request.SignupRequest;
import org.example.ge.domain.user.dto.response.LoginResponse;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserIdAlreadyExistsException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.example.ge.instrastructure.security.jwt.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserJpaRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;
    private final RatingRepository ratingRepository;

    public LoginResponse execute (SignupRequest request) {
        if (userRepository.getUserByUsername(request.username()).isPresent()) {
            throw UserIdAlreadyExistsException.EXCEPTION;
        }

        String encryptedPassword = bCryptPasswordEncoder.encode(request.password());

        User user = User.builder()
                .username(request.username())
                .nickname(request.nickname())
                .password(encryptedPassword)
                .target(request.target())
                .build();

        User newUser = userRepository.save(user);

        Rating rating = Rating.builder()
                .userId(newUser.getUserId())
                .rating(0)
                .totalExp(0.0)
                .build();

        ratingRepository.save(rating);

        return new LoginResponse(jwtService.generateAccess(newUser.getUserId()), request.nickname());
    }
}
