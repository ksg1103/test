package com.back.cafe.domain.product.dto;

import com.back.cafe.domain.product.entity.Product;

public record ProductDto(
        String name,
        String category,
        String description,
        String imageUrl,
        Long price
) {

    public ProductDto(Product product) {
        this(

                product.getName(),
                product.getCategory(),
                product.getDescription(),
                product.getImageUrl(),
                product.getPrice()
        );
    }
}