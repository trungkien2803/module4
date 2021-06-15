package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductService implements IProductService{
    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Milk",7000.0,"fresh","th"));
        products.put(2,new Product(2,"Milk2",7000.0,"fresh","th"));
        products.put(3,new Product(3,"Milk3",7000.0,"fresh","th"));
        products.put(4,new Product(4,"Milk4",7000.0,"fresh","th"));
        products.put(5,new Product(5,"Milk5",7000.0,"fresh","th"));
        products.put(6,new Product(6,"Milk6",7000.0,"fresh","th"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.replace(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for(Product product : findAll()){
            if (name.equals(product.getName())){
                productList.add(product);
            }
        }
        return productList;
    }
}
