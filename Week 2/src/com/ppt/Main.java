package com.ppt;

import com.ppt.utils.Order;
import com.ppt.utils.Product;
import com.ppt.utils.ProductType;

public class Main {


    public static void main(String[] args) {
        // Orders
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

        // Initialise order book here
//        OrderBook orderBook =

        System.out.println("Hi, you have compiled successfully");


    }
}
