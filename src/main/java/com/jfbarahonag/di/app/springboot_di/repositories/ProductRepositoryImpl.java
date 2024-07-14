package com.jfbarahonag.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.jfbarahonag.di.app.springboot_di.models.Product;

public class ProductRepositoryImpl {
  private List<Product> data;

  public ProductRepositoryImpl() {
    data = Arrays.asList(
        // default values
        new Product(1L, "Vela x10gr", 5500L),
        new Product(2L, "Caja de regalo", 1000L),
        new Product(3L, "Dulces", 200L));
  }

  public List<Product> findAll() {
    return data;
  }

  public Product findById(Long id) {
    return data.stream()
        .filter(product -> product.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

}
