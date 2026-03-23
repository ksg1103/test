package com.back.cafe.domain.product.controller;

import com.back.cafe.domain.product.dto.ProductDto;
import com.back.cafe.domain.product.entity.Product;
import com.back.cafe.domain.product.service.ProductService;
import com.back.cafe.global.rsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;

    record AdminProductRequest(
            @NotBlank
            String name,
            @NotBlank
            String category,
            @NotBlank
            String imageUrl,
            @NotBlank
            String description,
            @NotNull
            Long price
    ){}

    record ProductCreateResBody(
            Long id,
            ProductDto productDto

    ){}
    @PostMapping("/admin/products")
    public RsData<ProductCreateResBody> createProduct(
            @RequestBody @Valid AdminProductRequest adminProductRequest){

        Product product = productService.create(
                adminProductRequest.name,
                adminProductRequest.category,
                adminProductRequest.imageUrl,
                adminProductRequest.description,
                adminProductRequest.price);

        return new RsData<>(
                "%d번 상품이 추가되었습니다".formatted(product.getId()),
                "201-1",
                new ProductCreateResBody(
                        product.getId(),
                        new ProductDto(product)
                )
        );
    }

}
