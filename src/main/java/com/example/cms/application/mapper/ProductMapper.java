package com.example.cms.application.mapper;

import com.example.cms.application.dto.ProductDto;
import com.example.cms.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "contentId", source = "contentId")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "releaseDate", source = "releaseDate")
    @Mapping(target = "reservationStartDate", source = "reservationStartDate")
    @Mapping(target = "reservationEndDate", source = "reservationEndDate")
    @Mapping(target = "active", source = "active")
    ProductDto toDto(Product product);

    @Mapping(target = "contentId", source = "contentId")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "releaseDate", source = "releaseDate")
    @Mapping(target = "reservationStartDate", source = "reservationStartDate")
    @Mapping(target = "reservationEndDate", source = "reservationEndDate")
    default Product toDomain(ProductDto dto) {
        return Product.create(
                dto.getContentId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getReleaseDate(),
                dto.getReservationStartDate(),
                dto.getReservationEndDate(),
                dto.isActive()
        );
    }
} 