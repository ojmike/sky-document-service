package com.document.collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "evidence_category")
@Getter
@Setter
public class EvidenceCategory {

    @Id
    private String id;
    private String name;

    private String description;
}
