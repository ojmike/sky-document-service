package com.document.file.impl;

import com.document.config.ApplicationProperties;
import com.document.file.FileHandler;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
@ConditionalOnProperty(name = "file.upload.handler", havingValue = "gcp")
@RequiredArgsConstructor
public class GCPFileHandler implements FileHandler {

    private final ApplicationProperties applicationProperties;
    private final Storage storage;
    private String projectId;


    @Override
    public String upload(byte[] content) {

        BlobId blobId = BlobId.of(applicationProperties.getGoogleBucketName(), Hashing.sha256().hashBytes(content).toString());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        try {
            storage.createFrom(blobInfo, new ByteArrayInputStream(content));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return blobId.getName();
    }

}
