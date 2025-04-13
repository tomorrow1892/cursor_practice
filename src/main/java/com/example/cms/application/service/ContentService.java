package com.example.cms.application.service;

import com.example.cms.domain.model.Content;
import java.util.List;
import java.util.Optional;

public interface ContentService {
    List<Content> findAll();
    Optional<Content> findById(Long id);
    Content save(Content content);
} 