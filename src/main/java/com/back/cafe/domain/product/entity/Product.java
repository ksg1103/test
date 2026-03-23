package com.back.cafe.domain.product.entity;

import com.back.cafe.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Getter
public class Product extends BaseEntity {


    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private String imageUrl;

    @Column
    private Long price;

    public Product(String name, String category,String imageUrl, String description, Long price){
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }


}
