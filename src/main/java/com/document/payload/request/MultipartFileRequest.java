package com.document.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MultipartFileRequest {

    private MultipartFile file;

    private String identifier;
}
