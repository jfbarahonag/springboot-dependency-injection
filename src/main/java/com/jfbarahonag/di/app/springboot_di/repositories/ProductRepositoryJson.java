package com.jfbarahonag.di.app.springboot_di.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfbarahonag.di.app.springboot_di.models.Product;

@Repository
@Primary
public class ProductRepositoryJson implements ProductRepository {

  private List<Product> data;

  public ProductRepositoryJson() {
    loadData();
  }

  private void loadData() {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
    };
    InputStream inputStream = getClass().getResourceAsStream("/products.json");
    try {
      this.data = mapper.readValue(inputStream, typeReference);
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
