package dao;

import java.util.List;

import entity.Product;

public interface ProductDao {
	
	List<Product> getProducts();

	Product getProduct(long id);

	void createProduct(Product product);

	void deleteProduct(long id);

	void updateProduct(Product product);
	
}
