package com.document.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationProperties {
    @Value("${engagement.service.base.url}")
    private String engagementServiceBaseUrl;

    @Value("${engagement.exist.url.path}")
    private String engagementExistUrlPath;
    @Value("${google.project.id}")
    private String googleProjectId;
    @Value("${google.bucket.name}")
    private String googleBucketName;
    @Value("${aws.bucket.name}")
    private String awsBucketName;
}
