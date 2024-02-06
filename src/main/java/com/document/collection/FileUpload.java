package com.document.collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Document(collection = "file_upload")
@Getter
@Setter
public class FileUpload implements Serializable {
    @Id
    private String fileId;

    private String originalName;

    private String format;

    private String fileReference;

    private String provider;

    private LocalDateTime createdOn;

    private LocalDateTime modifiedOn;

}
