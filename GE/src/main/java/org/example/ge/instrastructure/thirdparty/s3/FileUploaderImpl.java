package org.example.ge.instrastructure.thirdparty.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.example.ge.instrastructure.common.file.FileUploader;
import org.example.ge.instrastructure.thirdparty.s3.exception.FileIOException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileUploaderImpl implements FileUploader {
    private final AmazonS3Client amazonS3Client;
    private final S3Properties s3Properties;

    @Override
    public String upload(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID() + file.getOriginalFilename();

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());

            amazonS3Client.putObject(s3Properties.bucket(), fileName, file.getInputStream(), metadata);

            return amazonS3Client.getResourceUrl(s3Properties.bucket(), fileName);
        } catch (IOException e) {
            throw FileIOException.EXCEPTION;
        }
    }

    @Override
    public void delete(String filePath) {
    }

    @Override
    public Boolean isExist(String filePath) {
        return null;
    }
}
