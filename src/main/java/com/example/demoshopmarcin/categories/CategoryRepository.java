package com.example.demoshopmarcin.categories;

import com.example.demoshopmarcin.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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