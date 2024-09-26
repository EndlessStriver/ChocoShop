package Dao;

import java.util.List;

import Entity.Category;

public interface CategoryDao {
	
	List<Category> getCategories();

	Category getCategory(long id);

	void createCategory(Category category);

	void updateCategory(Category category);

	void deleteCategory(long id);
	
}
