package org.example.ge.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.EditProfileImgRequest;
import org.example.ge.domain.user.entity.User;
import org.example.ge.domain.user.exception.UserNotFoundException;
import org.example.ge.domain.user.reposiotory.UserJpaRepository;
import org.example.ge.instrastructure.common.file.FileUploader;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditProfileImgService {
    private final FileUploader fileUploader;
    private final UserJpaRepository userRepository;
    private final CurrentUserProvider currentUserProvider;

    public void execute(EditProfileImgRequest request) {
        Long userId = currentUserProvider.getCurrentUserId();
        User user = userRepository.getUserByUserId(userId).orElseThrow(
                () -> UserNotFoundException.EXCEPTION
        );

        user.setProfile(fileUploader.upload(request.profile()));

        userRepository.save(user);
    }
}
