package Service;

import java.util.List;

import Entity.Category;

public interface CategoryService {
	
	List<Category> getCategories();

	Category getCategory(long id);

	void createCategory(Category category);

	void deleteCategory(long id);

	void updateCategory(Category category);
	
}
