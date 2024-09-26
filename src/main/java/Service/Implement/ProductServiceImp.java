package Service.Implement;

import java.util.List;

import Dao.ProductDao;
import Entity.Product;
import Service.ProductService;

public class ProductServiceImp implements ProductService {

	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProducts() {
		try {
			return productDao.getProducts();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product getProduct(long id) {
		try {
			return productDao.getProduct(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void createProduct(Product product) {
		try {
			productDao.createProduct(product);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteProduct(long id) {
		try {
			productDao.deleteProduct(id);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateProduct(Product product) {
		try {
			productDao.updateProduct(product);
		} catch (Exception e) {
			throw e;
		}
	}

}
