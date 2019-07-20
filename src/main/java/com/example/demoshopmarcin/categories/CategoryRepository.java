package com.example.demoshopmarcin.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryById(Long Id);

    @Query("select count(c) from Category c")
    Long checkSize();

    @Transactional
    default void updateCategory(Category categoryInMemoryDto) {
        save(categoryInMemoryDto);
    }
}