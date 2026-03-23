package com.back.cafe.domain.product.service;

import com.back.cafe.domain.product.dto.ProductDto;
import com.back.cafe.domain.product.entity.Product;
import com.back.cafe.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product create(String name, String category,String imageUrl, String description, Long price){
        Product product = new Product(name, category, imageUrl, description, price);
        return productRepository.save(product);

    }

}
