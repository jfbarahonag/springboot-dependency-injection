package com.jfbarahonag.di.app.springboot_di.services;

import java.util.List;

import com.jfbarahonag.di.app.springboot_di.models.Product;
import com.jfbarahonag.di.app.springboot_di.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {

  private ProductRepositoryImpl repository = new ProductRepositoryImpl();

  @Override
  public List<Product> findAll() {
    return repository.findAll().stream()
        .map(product -> {
          Double newPrice = product.getPrice() * 1.25d;
          String newName = product.getName().toUpperCase();
          Product updatedProduct = (Product) product.clone();
          updatedProduct.setPrice(newPrice.longValue());
          updatedProduct.setName(newName);
          return updatedProduct;
        })
        .toList();
  }

  @Override
  public Product findById(Long id) {
    return repository.findById(id);
  }
}
