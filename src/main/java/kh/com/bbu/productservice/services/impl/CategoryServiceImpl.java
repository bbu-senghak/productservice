package kh.com.bbu.productservice.services.impl;

import java.util.List;
import kh.com.bbu.productservice.dto.request.CategoryRequest;
import kh.com.bbu.productservice.entities.CategoryEntity;
import kh.com.bbu.productservice.exceptions.ApiException;
import kh.com.bbu.productservice.repositories.CategoryRepository;
import kh.com.bbu.productservice.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public void createCategory(CategoryRequest request) {
        CategoryEntity existName = categoryRepository.findByName(request.getName());
        if(existName != null){
            throw new ApiException("400","Duplicate category name");
        }
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(request.getName());
        categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}
