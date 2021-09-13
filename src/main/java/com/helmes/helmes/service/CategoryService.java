package com.helmes.helmes.service;

import com.helmes.helmes.dto.CategoryDto;
import com.helmes.helmes.model.Category;
import com.helmes.helmes.model.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public List<CategoryDto> getAll() {
        var data = categoryRepository.findAllByParentIsNull();
        return mapper.map(data, new TypeToken<List<CategoryDto>>() {
        }.getType());
    }

    public Iterable<Category> findAllById(List<Long> categories) {
        return categoryRepository.findAllById(categories);
    }

    @CacheEvict(value = "categories", allEntries = true)
    public List<Category> findAll() {
        return categoryRepository.findAllByParentIsNull();
    }
}
