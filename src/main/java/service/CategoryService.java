package service;

import java.util.List;

import entity.Category;

public interface CategoryService {
	
	List<Category> getCategories();

	Category getCategory(long id);

	void createCategory(Category category);

	void deleteCategory(long id);

	void updateCategory(Category category);
	
}
