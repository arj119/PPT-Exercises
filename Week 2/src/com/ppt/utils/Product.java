package com.ppt.utils;

import java.util.Map;

public class Product {
    private final ProductType type;
    private final int quantity;
    private final double perUnitProductionCost;

    public Product(ProductType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
        Map<ProductType, Double> productPrices = Map.of(
                ProductType.PAPER, 0.01,
                ProductType.BRICK, 0.3,
                ProductType.TILE, 3.2,
                ProductType.PIPING, 2.0,
                ProductType.CEMENT, 1.1
        );
        this.perUnitProductionCost = productPrices.get(type);
    }

    public ProductType getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getProductionCost() {
        return quantity * perUnitProductionCost;
    }
}
