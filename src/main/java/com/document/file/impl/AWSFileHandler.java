//package com.document.file.impl;
//
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.SdkClientException;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.document.config.ApplicationProperties;
//import com.document.file.FileHandler;
//import com.document.payload.response.FileUploadResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.OutputStream;
//import java.util.List;
//
//@Component
//@ConditionalOnProperty(name = "file.upload.handler", havingValue = "aws")
//@RequiredArgsConstructor
//@Slf4j
//public class AWSFileHandler implements FileHandler {
//
//    private final ApplicationProperties applicationProperties;
//    @Override
//    public String upload(byte[] content) {
//        Regions clientRegion = Regions.DEFAULT_REGION;
//        String bucketName = applicationProperties.getAwsBucketName();
//        String stringObjKeyName = "*** String object key name ***";
//        String fileObjKeyName = "*** File object key name ***";
//        String fileName = "*** Path to file to upload ***";
//
//        try {
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withRegion(clientRegion)
//                    .build();
//
//            // Upload a text string as a new object.
//            s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");
//
//            // Upload a file as a new object with ContentType and title specified.
//            PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.setContentType("plain/text");
//            metadata.addUserMetadata("title", "someTitle");
//            request.setMetadata(metadata);
//            s3Client.putObject(request);
//        } catch (AmazonServiceException e) {
//            log.info("Amazon S3 couldn't process request with exception {}", e.getMessage());
//            e.printStackTrace();
//        } catch (SdkClientException e) {
//            // Amazon S3 couldn't be contacted for a response, or the client
//            // couldn't parse the response from Amazon S3.
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
