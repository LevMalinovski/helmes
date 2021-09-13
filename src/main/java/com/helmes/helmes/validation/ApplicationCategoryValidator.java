package com.helmes.helmes.validation;

import com.helmes.helmes.model.Category;
import com.helmes.helmes.service.CategoryService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationCategoryValidator implements ConstraintValidator<ApplicationCategoryConstraint, List<Long>> {

    private final CategoryService categoryService;

    public ApplicationCategoryValidator(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {
        List<Category> categories = categoryService.findAll();
        final List<Long> ids = categories.stream().map(Category::getId).collect(Collectors.toList());
        value.stream()
                .filter(ids::contains)
                .findAny()
                .orElseThrow();

        return true;
    }
}
