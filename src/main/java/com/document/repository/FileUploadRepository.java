package com.document.repository;

import com.document.collection.FileUpload;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends MongoRepository<FileUpload, String> {
}
