package com.company.app;

import com.company.data.Drink;
import com.company.data.Food;
import com.company.data.Product;
import com.company.data.Rating;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Shop {

    public static void main(String[] args) {
	// write your code here
        Product p1 = new Drink(101, "Tea", BigDecimal.valueOf(1.99), Rating.THREE_STAR);
        Product p2 = new Drink(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Food p3 = new Food(103, "Cake", BigDecimal.valueOf(1.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = new Food(105, "cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());
        Product p5 = p3.applyRating(Rating.THREE_STAR);
        Product p8 = p4.applyRating(Rating.FIVE_STAR);
        Product p9 = p1.applyRating(Rating.TWO_STAR);
        System.out.println(p8);
        System.out.println(p9);
        System.out.println(p5);

        if (p3 instanceof Food) {
            LocalDate bestBefore = ((Food)p3).getBestBefore();
        }
        p3.getBestBefore();

        System.out.println(p1.getId() + " " +  p1.getName() + " " + p1.getPrice() + " " + p1.getDiscountRate() + " " +p1.getRating().getStars());
        System.out.println(p2.getId() + " " +  p2.getName() + " " + p2.getPrice() + " " + p2.getDiscountRate() + " " +p2.getRating().getStars());
        System.out.println(p3.getId() + " " +  p3.getName() + " " + p3.getPrice() + " " + p3.getDiscountRate() + " " +p3.getRating().getStars() + p3.getBestBefore());
        System.out.println(p4.getId() + " " +  p4.getName() + " " + p4.getPrice() + " " + p4.getDiscountRate() + " " +p4.getRating().getStars());
        System.out.println(p5.getId() + " " +  p5.getName() + " " + p5.getPrice() + " " + p5.getDiscountRate() + " " +p5.getRating().getStars());

        p1.toString();
        System.out.println(p2.toString());
        System.out.println(p2);
        System.out.println(p1.equals(p2));
    }
}
