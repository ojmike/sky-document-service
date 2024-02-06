package com.document.controller;

import com.document.payload.request.EvidenceCategoryRequest;
import com.document.payload.response.EvidenceCategoryResponse;
import com.document.service.EvidenceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evidence-categories")
@RequiredArgsConstructor
public class EvidenceCategoryController {

    private final EvidenceCategoryService evidenceCategoryService;

    @PostMapping
    public void createCategory(@RequestBody EvidenceCategoryRequest request) {
        evidenceCategoryService.createCategory(request);
    }

    @GetMapping
    public List<EvidenceCategoryResponse> fetchCategories(){
        return evidenceCategoryService.fetchAllCategories();
    }

}
