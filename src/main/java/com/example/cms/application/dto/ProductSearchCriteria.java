package com.example.cms.application.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductSearchCriteria {
    private String contentId;
    private String title;
    private Integer minPrice;
    private Integer maxPrice;
    private LocalDateTime releaseDateFrom;
    private LocalDateTime releaseDateTo;
    private LocalDateTime reservationStartDateFrom;
    private LocalDateTime reservationStartDateTo;
    private Boolean isActive;
} 