package com.jfbarahonag.di.app.springboot_di.models;

public class Product implements Cloneable {
  private Long id;
  private String name;
  private Long price;

  public Product() {
  }

  public Product(String name, Long price) {
    this.name = name;
    this.price = price;
  }

  public Product(Long id, String name, Long price) {
    this(name, price);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  @Override
  public Object clone() {
    try {
      return super.clone(); // automatic clonation
    } catch (CloneNotSupportedException e) {
      return new Product(id, name, price); // manual clonation
    }
  }
}
