package com.kodilla.tutorial;

public class Tutorial17Product {
    private String name;
    private Double price;
    private Integer quantity;

    public Tutorial17Product() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Tutorial17Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
