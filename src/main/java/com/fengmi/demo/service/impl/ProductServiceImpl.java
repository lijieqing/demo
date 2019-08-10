package com.fengmi.demo.service.impl;

import com.fengmi.demo.mapper.ProductMapper;
import com.fengmi.demo.model.Brand;
import com.fengmi.demo.model.Color;
import com.fengmi.demo.model.Product;
import com.fengmi.demo.model.ProductDetail;
import com.fengmi.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijie
 * @create 2019-07-01 20:30
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    @Override
    public List<Brand> findAllBrand() {
        return productMapper.findAllBrand();
    }

    @Override
    public Integer insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Override
    public Integer insertProductDetail(ProductDetail detail) {
        return productMapper.insertProductDetail(detail);
    }

    @Override
    public List<Color> findAllColor() {
        return productMapper.findAllColor();
    }

    @Override
    public Integer deleteProductByID(int id) {
        return productMapper.deleteProductByID(id);
    }

    @Override
    public Product findProductByID(int id) {
        return productMapper.findProductByID(id);
    }

    @Override
    public int updateProduct(ProductDetail detail) {
        return productMapper.updateProduct(detail);
    }
}
