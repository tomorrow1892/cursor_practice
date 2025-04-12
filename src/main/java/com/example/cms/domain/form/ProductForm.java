package com.example.cms.domain.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductForm {
    @NotBlank(message = "Content ID is required")
    private String contentId;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal price;

    @NotNull(message = "Release Date is required")
    private LocalDateTime releaseDate;

    @NotNull(message = "Reservation Start Date is required")
    private LocalDateTime reservationStartDate;

    @NotNull(message = "Reservation End Date is required")
    private LocalDateTime reservationEndDate;

    private boolean active = true;
} 