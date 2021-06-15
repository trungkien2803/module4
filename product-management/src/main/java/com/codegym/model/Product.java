package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private Double price;
    private String description;
    private String factory;


    public Product() {
    }

    public Product(int id, String name, Double price, String description, String factory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.factory = factory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
}
