package org.example.ge.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.EditProfileInfoRequest;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditProfileInfoService {
    private final UserJpaRepository userRepository;
    private final CurrentUserProvider currentUserProvider;

    public void execute(EditProfileInfoRequest request) {
        Long userId = currentUserProvider.getCurrentUserId();
        User user = userRepository.getUserByUserId(userId).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );

        if (request.nickname() != null) {
            user.setNickname(request.nickname());
        }
        if (request.target() != null) {
            user.setTarget(request.target());
        }

        userRepository.save(user);
    }
}
