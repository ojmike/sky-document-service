package com.document.collection;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document(collection = "file_upload")
public class FileUpload implements Serializable {

    private String hash;

    private LocalDateTime createdOn;

    private LocalDateTime modifiedOn;

}
