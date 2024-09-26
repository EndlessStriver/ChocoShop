package Service.Implement;

import java.util.List;

import Dao.CategoryDao;
import Entity.Category;
import Service.CategoryService;

public class CategoryServiceImp implements CategoryService{
	
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getCategories() {
		try {
			return categoryDao.getCategories();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Category getCategory(long id) {
		try {
			return categoryDao.getCategory(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void createCategory(Category category) {
		try {
			categoryDao.createCategory(category);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteCategory(long id) {
		try {
			categoryDao.deleteCategory(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateCategory(Category category) {
		try {
			categoryDao.updateCategory(category);
		} catch (Exception e) {
			throw e;
		}
	}

}
