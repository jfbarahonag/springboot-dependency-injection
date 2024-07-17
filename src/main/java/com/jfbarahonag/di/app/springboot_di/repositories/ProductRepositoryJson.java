package com.jfbarahonag.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfbarahonag.di.app.springboot_di.models.Product;

public class ProductRepositoryJson implements ProductRepository {

  private List<Product> data;

  public ProductRepositoryJson() {
    loadData();
  }

  private void loadData() {
    Resource resource = new ClassPathResource("/json/products.json");
    ObjectMapper mapper = new ObjectMapper();
    
    try {
      data = Arrays.asList(
          mapper.readValue(
              resource.getFile(),
              Product[].class));
    } catch (IOException e) {
      throw new RuntimeException("Unable to load products from JSON", e);
    }
  }

  @Override
  public List<Product> findAll() {
    return data;
  }

  @Override
  public Product findById(Long id) {
    return data.stream()
        .filter(product -> product.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

}
