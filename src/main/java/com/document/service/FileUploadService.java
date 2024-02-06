package com.document.service;

import com.document.payload.request.FileUploadRequest;
import com.document.payload.response.FileUploadResponse;

import java.util.List;

public interface FileUploadService {
    List<FileUploadResponse> uploadFile(FileUploadRequest fileUploadRequest);
}
