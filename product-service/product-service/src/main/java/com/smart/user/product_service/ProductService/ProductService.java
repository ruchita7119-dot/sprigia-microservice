package com.smart.user.product_service.ProductService;

import java.util.List;

import com.smart.user.product_service.entity.Product;

public interface ProductService {

	Product addProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(Long id);
	Product updateProduct(Long id,Product product);
	void deleteProduct(Long id);
	
}
