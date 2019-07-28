package com.fengmi.demo.mapper;

import com.fengmi.demo.model.Brand;
import com.fengmi.demo.model.Color;
import com.fengmi.demo.model.Product;
import com.fengmi.demo.model.ProductDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProduct();

    Integer insertProduct(Product product);

    Integer insertProductDetail(ProductDetail detail);

    List<Brand> findAllBrand();

    List<Color> findAllColor();

    Integer deleteProductByID(int id);
}
