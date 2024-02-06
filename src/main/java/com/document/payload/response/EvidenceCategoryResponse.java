package com.document.payload.response;

import com.document.collection.EvidenceCategory;
import lombok.Data;

@Data
public class EvidenceCategoryResponse {
    private String id;
    private String name;
    private String description;

    public static EvidenceCategoryResponse from(EvidenceCategory category){
        EvidenceCategoryResponse response = new EvidenceCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        return response;
    }

}
