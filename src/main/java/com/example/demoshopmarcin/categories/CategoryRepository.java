package com.example.demoshopmarcin.categories;

import com.example.demoshopmarcin.BaseEntity;
import com.example.demoshopmarcin.MockedData.MockedCategoriesSource;
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

    default List<Category> getCategories(){
        CreateBasicCategories();
        return findAll();
    }

    default void CreateBasicCategories(){
        if (checkSize()!=0){
            return;
        }
        List<Category> categories = MockedCategoriesSource.getInstance().getMockedCategories()
                .stream()
                .sorted(Comparator.comparingLong(BaseEntity::getId))
                .collect(toList());
        for (Category category : categories) {
            Long temp = category.getId();
            Category saved = save(category);
            if (saved.getParentId() == null) {
                continue;
            }
            List<Category> categoryStream = categories
                    .stream()
                    .filter(e -> e.getParentId() != null)
                    .filter(e -> temp.equals(e.getParentId()))
                    .collect(toList());
            categoryStream.forEach(e -> e.setParentId(saved.getId()));
        }
    }
}
