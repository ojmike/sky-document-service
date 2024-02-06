package com.document.collection;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "file_evidence_category")
public class FileEvidenceCategory {
    private String fileId;
    private String categoryId;
}
