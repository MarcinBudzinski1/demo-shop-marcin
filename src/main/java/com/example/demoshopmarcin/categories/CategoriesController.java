package com.example.demoshopmarcin.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class CategoriesController {

    private CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public String showCategories(Model model, @RequestParam(required = false) String searchText) {
        List<CategoryDTO> categoryDTOList = categoriesService.filterCategories(searchText);
        model.addAttribute("catsdata", categoryDTOList);
        return "categories";
    }

    @PostMapping("/categories/moveCat")
    @ResponseBody
    public void moveCategory(@RequestParam(required = true) String oldParentId, @RequestParam(required = true) String newParentId, @RequestParam(required = true) String movedId) {
        categoriesService.moveCategory(newParentId, movedId);
    }

    @GetMapping("/category")
    public String addCategoryForm() {
        return "addCategory";
    }

    @PostMapping("/category")
    public String addCategory(@RequestParam String categoryName,@RequestParam Long parentId) {
        categoriesService.addCategory(categoryName, parentId);
        return  "redirect:/admin/categories";
    }

}
