package com.document.service.serviceImpl;


import com.document.collection.FileUpload;
import com.document.config.ApplicationProperties;
import com.document.exception.BadRequestException;
import com.document.file.FileHandler;
import com.document.payload.request.FileUploadRequest;
import com.document.payload.response.FileUploadResponse;
import com.document.repository.FileUploadRepository;
import com.document.service.EvidenceCategoryService;
import com.document.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadRepository fileUploadRepository;

    private final RestTemplate restTemplate;

    private final ApplicationProperties applicationProperties;

    private final EvidenceCategoryService evidenceCategoryService;

    private final FileHandler fileHandler;


    @Override
    public List<FileUploadResponse> uploadFile(FileUploadRequest fileUploadRequest) {

        // Check if Engagement Exist
        String url = applicationProperties.getEngagementServiceBaseUrl().concat(applicationProperties.getEngagementExistUrlPath()).concat(fileUploadRequest.getEngagementId());
//        Boolean exist = restTemplate.getForObject(url, Boolean.class);
//        if(!exist) throw new BadRequestException(String.format("Engagement with id %s does not exist in the system", fileUploadRequest.getEngagementId()));

        // Check if Category Exist
        boolean categoryExist = evidenceCategoryService.existById(fileUploadRequest.getCategoryId());
        if (!categoryExist)
            throw new BadRequestException(String.format("Category with id %s does not exist in the system", fileUploadRequest.getCategoryId()));

        List<FileUploadResponse> fileUploadResponseList = new ArrayList<>();

        //Upload File
        fileUploadRequest.getDocuments().forEach(multipartFile -> {
            try {
                String fileReference = fileHandler.upload(multipartFile.getFile().getBytes());

                FileUpload fileUpload = createFile(multipartFile.getFile(), fileReference);

                FileUploadResponse response = new FileUploadResponse();
                response.setFileId(fileUpload.getFileId());
                response.setIdentifier(multipartFile.getIdentifier());
                fileUploadResponseList.add(response);

            } catch (IOException e) {
                log.error(e.getMessage());
                throw new RuntimeException(e);
            }
        });
        return fileUploadResponseList;

    }

    private FileUpload createFile(MultipartFile file, String fileReference) {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setFileReference(fileReference);
        fileUpload.setCreatedOn(LocalDateTime.now());
        fileUpload.setModifiedOn(LocalDateTime.now());
        fileUpload.setOriginalName(file.getOriginalFilename());
        fileUpload.setFormat(file.getContentType());
        fileUpload.setProvider("");
        fileUpload = fileUploadRepository.save(fileUpload);
        return fileUpload;
    }
}
