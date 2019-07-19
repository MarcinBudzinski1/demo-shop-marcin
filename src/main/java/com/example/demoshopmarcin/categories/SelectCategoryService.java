package com.example.demoshopmarcin.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Primary
public class SelectCategoryService extends CategoriesService{

    @Autowired
    protected SelectCategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }

    @Override
    public List<CategoryDTO> filterCategories(String searchText) {
        Map<Long, CategoryDTO> dtoMap = getCategories().stream()
                .collect(Collectors.toMap(CategoryDTO::getId, v -> v));

        return dtoMap.values().stream()
                .peek(dto -> dto.setParentCategory(dtoMap.get(dto.getParentId())))
                .map(dto -> populateStateAndOpenParents(dto, searchText))
                .collect(Collectors.toList());
    }
}
