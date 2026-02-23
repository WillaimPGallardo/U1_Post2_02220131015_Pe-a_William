package service;

import factory.ProductFactory;
import model.*;
import observer.*;
import strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements OrderSubject {

    private List<OrderObserver> observers = new ArrayList<>();
    private Order order;

    public OrderService(String orderId) {
        this.order = new Order(orderId);
    }

    public void addProduct(String type, String name, double price) {
        Product product = ProductFactory.createProduct(type, name, price);
        order.addProduct(product);
    }

    public double calculateTotal(PricingStrategy strategy) {
        double total = 0;
        for (Product p : order.getProducts()) {
            total += strategy.calculateFinalPrice(p.getBasePrice())
                    + p.calculateShipping();
        }
        return total;
    }

    public void changeStatus(String newStatus) {
        String oldStatus = order.getStatus();
        order.setStatus(newStatus);
        notifyObservers(order.getOrderId(), oldStatus, newStatus);
    }

    @Override
    public void subscribe(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String orderId, String oldStatus, String newStatus) {
        for (OrderObserver obs : observers) {
            obs.update(orderId, oldStatus, newStatus);
        }
    }

    public void printSummary() {
        System.out.println("\n===== RESUMEN PEDIDO =====");
        for (Product p : order.getProducts()) {
            System.out.println(p.getDescription());
        }
        System.out.println("Estado actual: " + order.getStatus());
    }
}