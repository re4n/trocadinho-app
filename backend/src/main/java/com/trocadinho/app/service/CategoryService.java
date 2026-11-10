package com.trocadinho.app.service;

import com.sun.jdi.request.DuplicateRequestException;
import com.trocadinho.app.dto.CategoryRequest;
import com.trocadinho.app.dto.CategoryResponse;
import com.trocadinho.app.exception.AppError;
import com.trocadinho.app.exception.AppException;
import com.trocadinho.app.model.Category;
import com.trocadinho.app.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryResponse create(CategoryRequest categoryRequest) {
        if(categoryRepository.existsByName(categoryRequest.name())){
            throw new DuplicateRequestException("Category with name " + categoryRequest.name() + " already exists");
        }
        Category category = categoryRepository.save(new Category(categoryRequest.name()));
        return CategoryResponse.from(category);
    }

    @Transactional
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryResponse::from)
                .toList();
    }

//    @Transactional(readOnly = true)
//    public CategoryResponse findById(Long id){
//        Category category = categoryRepository.findById(id).orElseThrow(() -> new AppException(AppError.RESOURCE_NOT_FOUND, "" )
//
//    }
}
