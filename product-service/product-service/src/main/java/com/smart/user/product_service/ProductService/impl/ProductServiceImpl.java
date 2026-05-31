package com.smart.user.product_service.ProductService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.user.product_service.ProductService.ProductService;
import com.smart.user.product_service.entity.Product;
import com.smart.user.product_service.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
		
	}
	
	@Override
	public Product updateProduct(Long id,Product updatedProduct) {
		Product existing = getProductById(id);
		existing.setName(updatedProduct.getName());
		existing.setPrice(updatedProduct.getPrice());
		existing.setQuantity(updatedProduct.getQuantity());
		
		return productRepository.save(existing);
	}
	
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	
}
