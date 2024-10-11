package org.example.ge.instrastructure.common.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploader {
    /**
     *
     * @param file 업로드할 파일
     * @return 업로드된 파일의 URL
     */
    String upload(MultipartFile file);

    void delete(String filePath);

    Boolean isExist(String filePath);
}
