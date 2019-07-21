package com.example.demoshopmarcin.categories;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CategoriesService {

    private CategoryRepository categoryRepository;

    @Autowired
    protected CategoriesService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public abstract List<CategoryDTO> filterCategories(String searchText);

    public List<CategoryDTO> getCategories() {
        List<Category> categoryList = categoryRepository.getCategories();
        return categoryList.stream().map(this::buildCategoryDTO).collect(Collectors.toList());
    }

    public Optional<Category> getCategoryById(Long movedId) {
        return categoryRepository.findCategoryById(movedId);
    }

    public void moveCategory(String newParentId, String movedId) {
        Category movedCategory = getCategoryById(Long.valueOf(movedId)).get();
        movedCategory.setParentId(Long.valueOf(newParentId));
        categoryRepository.updateCategory(movedCategory);
    }

    protected CategoryDTO buildCategoryDTO(Category c) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(c.getId());
        categoryDTO.setParentId(c.getParentId());
        categoryDTO.setCategoryName(c.getCategoryName());
        categoryDTO.setDepth(c.getDepth());
        categoryDTO.setCategoryState(new CategoryState());
        return categoryDTO;
    }

    protected CategoryDTO populateStateAndOpenParents(CategoryDTO dto, String searchText) {
        if (searchText != null && dto.getCategoryName().equals(searchText.trim())) {
            dto.getCategoryState().setOpened(true);
            dto.getCategoryState().setSelected(true);

        }
        return dto;
    }

    protected void openParent(CategoryDTO child) {
        CategoryDTO parentCat = child.getParentCategory();
        if (parentCat == null) {
            return;
        }
        parentCat.getCategoryState().setOpened(true);
        openParent(parentCat);
    }

    public void addCategory(String catName, Long parentId) {
        categoryRepository.save(new Category(parentId == 0 ? null : parentId, catName));
    }
}
