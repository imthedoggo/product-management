package com.company.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product{

    private java.time.LocalDate bestBefore;

    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(), getName(), getPrice(), newRating, bestBefore);
    }

    @Override
    public BigDecimal getDiscountRate() {
        return (bestBefore.isEqual(LocalDate.now())
            ? super.getDiscountRate() : BigDecimal.ZERO);
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + bestBefore;
    }
}
