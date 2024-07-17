package com.jfbarahonag.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jfbarahonag.di.app.springboot_di.repositories.ProductRepository;
import com.jfbarahonag.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

  @Bean("inFileData")
  ProductRepository productRepositoryJson() {
    return new ProductRepositoryJson();
  }
}
