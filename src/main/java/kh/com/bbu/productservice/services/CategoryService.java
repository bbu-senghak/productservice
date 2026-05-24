package kh.com.bbu.productservice.services;

import java.util.List;
import kh.com.bbu.productservice.dto.request.CategoryRequest;
import kh.com.bbu.productservice.entities.CategoryEntity;

public interface CategoryService {
    void createCategory(CategoryRequest request);
    List<CategoryEntity> getAllCategories();
}
