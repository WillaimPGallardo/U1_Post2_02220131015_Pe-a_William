package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderId;
    private String status;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "CREATED";
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}