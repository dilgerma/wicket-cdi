package de.effectivetrainings.products;

import java.io.Serializable;

/**
 * @author Martin Dilger
 * @since: 27.04.13
 */
public class Product implements Serializable{

    private String name;
    private Double prize;

    public Product(String name, Double prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public Double getPrize() {
        return prize;
    }
}
