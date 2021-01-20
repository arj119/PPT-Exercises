package com.ppt;

import com.ppt.utils.Order;
import com.ppt.utils.Product;
import com.ppt.utils.ProductType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OrderBookTest {

    private final OrderBook orderBook = new StreamOrderBook();

    Order order1 = new Order.Builder("Peter")
            .withProduct(new Product(ProductType.PAPER, 1000))
            .build();

    Order order2 = new Order.Builder("Mayank")
            .withProduct(new Product(ProductType.PAPER, 50))
            .withProduct(new Product(ProductType.BRICK, 400))
            .build();

    Order order3 = new Order.Builder("Peter")
            .withProduct(new Product(ProductType.PAPER, 100))
            .withProduct(new Product(ProductType.PIPING, 500))
            .withProduct(new Product(ProductType.TILE, 12000))
            .build();

    Order order4 = new Order.Builder("Peter")
            .withProduct(new Product(ProductType.PAPER, 1000))
            .withProduct(new Product(ProductType.CEMENT, 51))
            .withProduct(new Product(ProductType.BRICK, 120))
            .withProduct(new Product(ProductType.TILE, 9523))
            .withProduct(new Product(ProductType.PIPING, 42))
            .build();


    @Test
    void orderBookIsInitiallyEmpty() {
        assertTrue(orderBook.isEmpty());
    }

    @Test
    void addedOrderIsContainedInOrderBook() {
        orderBook.addOrder(order1);

        assertEquals(1, orderBook.getNumberOfOrders());
        assertTrue(orderBook.containsOrder(order1));
    }

    @Test
    void completedOrderIsRemovedFromOrderBook() {
        orderBook.addOrder(order1);

        orderBook.completeOrder(order1);
        assertTrue(orderBook.isEmpty());
        assertFalse(orderBook.containsOrder(order1));
    }

    @Test
    void countProductOrders() {
        orderBook.addOrder(order1);
        orderBook.addOrder(order2);
        orderBook.addOrder(order3);
        orderBook.addOrder(order4);

        assertEquals(4, orderBook.countProductOrders(ProductType.PAPER));
        assertEquals(2, orderBook.countProductOrders(ProductType.BRICK));
        assertEquals(2, orderBook.countProductOrders(ProductType.PIPING));
        assertEquals(2, orderBook.countProductOrders(ProductType.TILE));
        assertEquals(1, orderBook.countProductOrders(ProductType.CEMENT));
    }

    @Test
    void calculateProductCosts() {
        orderBook.addOrder(order1);
        orderBook.addOrder(order2);
        orderBook.addOrder(order3);
        orderBook.addOrder(order4);

        assertEquals(21.5, orderBook.countProductOrders(ProductType.PAPER));
    }

    @Test
    void findOrdersLessThan() {
        orderBook.addOrder(order1);
        orderBook.addOrder(order2);
        orderBook.addOrder(order3);
        orderBook.addOrder(order4);

        assertEquals(List.of(order2, order3), orderBook.findOrdersLessThan(ProductType.PAPER, 400));
    }
}