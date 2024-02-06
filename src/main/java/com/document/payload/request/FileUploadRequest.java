package com.document.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class FileUploadRequest {

    private List<MultipartFileRequest> documents;

    private String categoryId;

    private String engagementId;

}
