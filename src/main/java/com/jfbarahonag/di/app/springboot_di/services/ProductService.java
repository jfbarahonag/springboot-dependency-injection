package com.jfbarahonag.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jfbarahonag.di.app.springboot_di.models.Product;
import com.jfbarahonag.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

  private ProductRepository repository = new ProductRepository();

  public List<Product> findAll() {
    return repository.findAll().stream()
        .map(product -> {
          product.setName(product.getName().toUpperCase());
          product.setPrice(product.getPrice() * (long)1.25);
          return product;
        })
        .collect(Collectors.toList());
        // TODO: Check if this is needed
        // .toList();
  }

  public Product findById(Long id) {
    return repository.findById(id);
  }
}
