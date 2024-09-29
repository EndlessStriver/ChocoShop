package dao;

import java.util.List;

import entity.Category;

public interface CategoryDao {
	
	List<Category> getCategories();

	Category getCategory(long id);

	void createCategory(Category category);

	void updateCategory(Category category);

	void deleteCategory(long id);
	
}
