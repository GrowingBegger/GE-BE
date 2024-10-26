package org.example.ge.instrastructure.thirdparty.s3;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cloud")
public record S3Properties(
        String bucket
) {
}
