package org.example.ge.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.response.GetProfileResponse;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserProfileService {
    private final CurrentUserProvider currentUserProvider;
    private final UserJpaRepository userRepository;

    public GetProfileResponse execute() {
        Long userId = currentUserProvider.getCurrentUserId();

        User user = userRepository.getUserByUserId(userId).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );

        return new GetProfileResponse(
                user.getNickname(),
                user.getUserRank(),
                user.getTarget(),
                user.getProfile()
        );
    }
}