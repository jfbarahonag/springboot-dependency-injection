package com.jfbarahonag.di.app.springboot_di.services;

import java.util.List;

import com.jfbarahonag.di.app.springboot_di.models.Product;
import com.jfbarahonag.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

  private ProductRepository repository = new ProductRepository();

  public List<Product> findAll() {
    return repository.findAll().stream()
        .map(product -> {
          Double newPrice = product.getPrice() * 1.25d;
          Product updatedProduct = new Product(
              product.getId(),
              product.getName().toUpperCase(),
              newPrice.longValue());
          return updatedProduct;
        })
        .toList();
  }

  public Product findById(Long id) {
    return repository.findById(id);
  }
}
