package com.company.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Product {

    /**
     * A constant that defines a {@link java.math.BigDecimal BigDecimal} value
     * of a discount rate
     * <br>
     *     Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private final int id;
    private final String name;
    private final BigDecimal price;
    private Rating rating;

    @Override
    public String toString() {
        return "ProductID: " +
             + id +
            ", name=' " + name + '\'' +
            ", price= " + price +
            ", discount= " + getDiscountRate() +
            ", rating=" + rating +
            " " + rating.getStars() +
            ", best before: " + getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id &&
            Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    public abstract Product applyRating(Rating newRating);
//    {
//        return new Product(id, name, price, newRating);
//    }

    public BigDecimal getDiscountRate() {
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }
}
