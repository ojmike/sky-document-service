package com.document.repository;

import com.document.collection.EvidenceCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvidenceCategoryRepository extends MongoRepository<EvidenceCategory, String> {
    boolean existsByName(String name);
}
