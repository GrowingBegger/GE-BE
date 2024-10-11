package org.example.ge.instrastructure.thirdparty.s3;

import org.example.ge.instrastructure.common.file.FileUploader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderImpl implements FileUploader {
    // TODO :: 로직 작성
    @Override
    public String upload(MultipartFile file) {
        return "";
    }

    @Override
    public void delete(String filePath) {

    }

    @Override
    public Boolean isExist(String filePath) {
        return null;
    }
}
