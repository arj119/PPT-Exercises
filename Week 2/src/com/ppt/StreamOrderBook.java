package com.ppt;

import com.ppt.utils.Order;
import com.ppt.utils.ProductType;

import java.util.ArrayList;
import java.util.List;

public class StreamOrderBook implements OrderBook {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return orders.isEmpty();
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void completeOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public boolean containsOrder(Order order) {
        return orders.contains(order);
    }

    @Override
    public int getNumberOfOrders() {
        return orders.size();
    }

    @Override
    public int countProductOrders(ProductType product) {
        // orders.stream()
        // .map((o) -> o.getProductsStream()
        // .filter((p) -> p.getType() == product)) 
        // .getNumberOfOrders();
        return (int) orders.stream().filter((o) -> o.getProductsStream().anyMatch((p) -> p.getType() == product)).count();
    }

    @Override
    public int calculateProductCosts(ProductType product) {
        return 0;
    }

    @Override
    public List<Order> findOrdersLessThan(ProductType product, int maxQuantity) {
        return null;
    }
}
