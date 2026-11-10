package com.trocadinho.app.dto;

import com.trocadinho.app.model.Category;

public record CategoryResponse (Long id, String name) {
    public static CategoryResponse from (Category category){
        return new CategoryResponse(category.getId(), category.getName());
    }
}
