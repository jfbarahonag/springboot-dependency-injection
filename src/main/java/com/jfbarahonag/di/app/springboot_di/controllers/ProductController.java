package com.jfbarahonag.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfbarahonag.di.app.springboot_di.models.Product;
import com.jfbarahonag.di.app.springboot_di.services.ProductServiceImpl;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

  @Autowired
  private ProductServiceImpl productService;

  @GetMapping
  public List<Product> list() {
    return productService.findAll();
  }

  @GetMapping("/{id}")
  public Product getProduct(@PathVariable Long id) {
    return productService.findById(id);
  }

}
