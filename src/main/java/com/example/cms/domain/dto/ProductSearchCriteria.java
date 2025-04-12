package com.example.cms.domain.dto;

import java.time.LocalDateTime;

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

    // Getters and Setters
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public LocalDateTime getReleaseDateFrom() {
        return releaseDateFrom;
    }

    public void setReleaseDateFrom(LocalDateTime releaseDateFrom) {
        this.releaseDateFrom = releaseDateFrom;
    }

    public LocalDateTime getReleaseDateTo() {
        return releaseDateTo;
    }

    public void setReleaseDateTo(LocalDateTime releaseDateTo) {
        this.releaseDateTo = releaseDateTo;
    }

    public LocalDateTime getReservationStartDateFrom() {
        return reservationStartDateFrom;
    }

    public void setReservationStartDateFrom(LocalDateTime reservationStartDateFrom) {
        this.reservationStartDateFrom = reservationStartDateFrom;
    }

    public LocalDateTime getReservationStartDateTo() {
        return reservationStartDateTo;
    }

    public void setReservationStartDateTo(LocalDateTime reservationStartDateTo) {
        this.reservationStartDateTo = reservationStartDateTo;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
} 