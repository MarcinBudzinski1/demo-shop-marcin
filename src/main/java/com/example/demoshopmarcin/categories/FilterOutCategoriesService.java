package com.example.demoshopmarcin.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FilterOutCategoriesService extends  CategoriesService{

    @Autowired
    public FilterOutCategoriesService(CategoryRepository categoryRepository){
        super(categoryRepository);
    }

    public List<CategoryDTO> filterCategories(String searchText) {
        Map<Long, CategoryDTO> dtoMap = getCategories().stream()
                .collect(Collectors.toMap(CategoryDTO::getId, v -> v));
        return dtoMap.values().stream()
                .peek(dto -> dto.setParentCategory(dtoMap.get(dto.getParentId())))
                .map(dto -> populateStateAndOpenParents(dto, searchText))
                .filter(e -> e.getCategoryState().isOpened())
                .collect(Collectors.toList());
    }
}
