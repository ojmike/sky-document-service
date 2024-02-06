package com.document.service.serviceImpl;

import com.document.collection.EvidenceCategory;
import com.document.exception.BadRequestException;
import com.document.payload.request.EvidenceCategoryRequest;
import com.document.payload.response.EvidenceCategoryResponse;
import com.document.repository.EvidenceCategoryRepository;
import com.document.service.EvidenceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EvidenceCategoryServiceImpl implements EvidenceCategoryService {

    private final EvidenceCategoryRepository repository;

    @Override
    public void createCategory(EvidenceCategoryRequest request) {
        boolean existByName = repository.existsByName(request.getName());
        if(existByName) throw new BadRequestException("Category is already existing");

        EvidenceCategory evidenceCategory = new EvidenceCategory();
        evidenceCategory.setName(request.getName());
        evidenceCategory.setDescription(request.getDescription());
        repository.save(evidenceCategory);
    }

    @Override
    public List<EvidenceCategoryResponse> fetchAllCategories() {
        return repository.findAll().stream().map(EvidenceCategoryResponse::from).collect(Collectors.toList());
    }

    @Override
    public boolean existById(String categoryId) {
        return repository.existsById(categoryId);
    }

    public static void printTime(){
        System.out.println(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        printTime();
    }
}
