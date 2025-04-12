package com.example.cms.domain.specification;

import com.example.cms.domain.dto.ProductSearchCriteria;
import com.example.cms.domain.model.Product;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    public static Specification<Product> searchProducts(ProductSearchCriteria criteria) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getContentId() != null && !criteria.getContentId().isEmpty()) {
                predicates.add(cb.like(root.get("contentId"), "%" + criteria.getContentId() + "%"));
            }

            if (criteria.getTitle() != null && !criteria.getTitle().isEmpty()) {
                predicates.add(cb.like(root.get("title"), "%" + criteria.getTitle() + "%"));
            }

            if (criteria.getMinPrice() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), criteria.getMinPrice()));
            }

            if (criteria.getMaxPrice() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), criteria.getMaxPrice()));
            }

            if (criteria.getReleaseDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("releaseDate"), criteria.getReleaseDateFrom()));
            }

            if (criteria.getReleaseDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("releaseDate"), criteria.getReleaseDateTo()));
            }

            if (criteria.getReservationStartDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("reservationStartDate"), criteria.getReservationStartDateFrom()));
            }

            if (criteria.getReservationStartDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("reservationStartDate"), criteria.getReservationStartDateTo()));
            }

            if (criteria.getIsActive() != null) {
                predicates.add(cb.equal(root.get("active"), criteria.getIsActive()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
} 