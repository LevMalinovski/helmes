package com.helmes.helmes.model.repository;

import com.helmes.helmes.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAllByParentIsNull();
}
