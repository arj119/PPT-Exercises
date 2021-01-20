package com.ppt;

import com.ppt.utils.Order;
import com.ppt.utils.ProductType;

import java.util.ArrayList;
import java.util.List;

public class IterativeOrderBook implements OrderBook {
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
        return false;
    }

    @Override
    public int getNumberOfOrders() {
        return 0;
    }

    @Override
    public int countProductOrders(ProductType product) {
        return 0;
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
