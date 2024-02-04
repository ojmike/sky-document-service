package com.document.payload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class FileUploadRequest {

    private List<MultipartFile> documents;

}
