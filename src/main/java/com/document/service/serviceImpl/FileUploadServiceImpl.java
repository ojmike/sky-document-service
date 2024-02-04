package com.document.service.serviceImpl;

import com.document.collection.FileUpload;
import com.document.exception.ServerErrorException;
import com.document.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class FileUploadServiceImpl {


    public boolean fileExist(MultipartFile file) {
        boolean flag = true;
        String hashedFile;

        try {
            hashedFile = Util.getFileHash(file.getBytes());
        } catch (NoSuchAlgorithmException | IOException e) {

            log.error("Error processing document ", e);
            throw new ServerErrorException("Error processing document, Please try again!");
        }
//
//        if (ObjectUtils.isEmpty(findFileByHashValue(hashedFile))) {
//            flag = false;
//        }

        return flag;
    }
}
