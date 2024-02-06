package com.document.payload.response;

import lombok.Data;

@Data
public class FileUploadResponse {
    private String identifier;

    private String fileId;
}
