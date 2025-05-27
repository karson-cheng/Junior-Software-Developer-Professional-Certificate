package com.demo.spring_data_jpa.service;

import com.demo.spring_data_jpa.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
}
