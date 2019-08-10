package com.fengmi.demo.service;

import com.fengmi.demo.model.Brand;
import com.fengmi.demo.model.Color;
import com.fengmi.demo.model.Product;
import com.fengmi.demo.model.ProductDetail;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    List<Brand> findAllBrand();

    Integer insertProduct(Product product);

    Integer insertProductDetail(ProductDetail detail);

    List<Color> findAllColor();

    Integer deleteProductByID(int id);

    Product findProductByID(int id);

    int updateProduct(ProductDetail detail);
}
