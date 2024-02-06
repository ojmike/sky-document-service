package com.document.controller;

import com.document.payload.request.FileUploadRequest;
import com.document.payload.response.FileUploadResponse;
import com.document.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/file-upload")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @PostMapping
    public List<FileUploadResponse> uploadFile(@ModelAttribute FileUploadRequest fileUploadRequest){
        return fileUploadService.uploadFile(fileUploadRequest);
    }
}
