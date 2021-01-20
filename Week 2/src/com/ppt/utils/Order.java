package com.ppt.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Order {
    private final String customerName;
    private final List<Product> products;

    private Order(String customerName, List<Product> products) {
        this.customerName = customerName;
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Stream<Product> getProducts() {
        return products.stream();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getProducts());
    }

    public static class Builder {
        private final String customerName;
        private final List<Product> products = new ArrayList<>();

        public Builder(String customerName) {
            this.customerName = customerName;
        }

        public Builder withProduct(Product product) {
            products.add(product);
            return this;
        }

        public Order build() {
            return new Order(customerName, products);
        }
    }
}
