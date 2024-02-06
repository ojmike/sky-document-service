package com.document.service;

import com.document.payload.request.EvidenceCategoryRequest;
import com.document.payload.response.EvidenceCategoryResponse;

import java.util.List;

public interface EvidenceCategoryService {
    void createCategory(EvidenceCategoryRequest request);

    List<EvidenceCategoryResponse> fetchAllCategories();

    boolean existById(String categoryId);
}
