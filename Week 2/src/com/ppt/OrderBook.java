package com.ppt;

import com.ppt.utils.Order;
import com.ppt.utils.ProductType;

import java.util.List;

/**
 * An interface for an order book. This will manage orders.
 */
public interface OrderBook {
    /**
     * Returns true if order book is empty
     *
     * @return true if order book is empty
     */
    boolean isEmpty();

    /**
     * Adds order to order book
     *
     * @param order Order to be added
     */
    void addOrder(Order order);

    /**
     * Order is removed from the order book
     *
     * @param order Order to be removed
     */
    void completeOrder(Order order);

    /**
     * Returns all orders in order book
     *
     * @return copy of a list of orders present in the order book
     */
    List<Order> getOrders();

    /**
     * Returns true if the order is present in the order book
     *
     * @param order Order to be searching for
     * @return true if order is present
     */
    boolean containsOrder(Order order);

    /**
     * Returns number of orders in the order book
     *
     * @return number of orders in order book
     */
    int getNumberOfOrders();

    /**
     * Returns how many orders there are with the name productName
     *
     * @param product Product type
     * @return Number of orders for product
     */
    int countProductOrders(ProductType product);

    /**
     * Returns the production cost of the product given the current orders
     *
     * @param product Product type
     * @return Cost of production over all orders
     */
    int calculateProductCosts(ProductType product);

    /**
     * Returns orders which contain less than maxQuantity of product
     *
     * @param product     Product type
     * @param maxQuantity Maximum quantity inclusive
     * @return List of orders who have less than or equal to the maxQuantity of product
     */
    List<Order> findOrdersLessThan(ProductType product, int maxQuantity);


    // Extension implement inventory service
    //
    // List<Order> findOrdersThatCanBeFulfilled();
}
