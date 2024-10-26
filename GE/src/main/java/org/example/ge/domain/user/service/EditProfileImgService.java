package org.example.ge.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.user.dto.request.EditProfileImgRequest;
import org.example.ge.domain.user.dto.response.EditProfileImgResponse;
import org.example.ge.instrastructure.common.file.FileUploader;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditProfileImgService {
    private final FileUploader fileUploader;

    public EditProfileImgResponse execute(EditProfileImgRequest request) {
        return new EditProfileImgResponse(fileUploader.upload(request.profile()));
    }
}
