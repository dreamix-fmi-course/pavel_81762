package entity;

import java.math.BigDecimal;

/**
 * Implement Item with description:String and price:BigDecimal
 */

public class Item {
    private String description;
    private BigDecimal price;

    Item(String description, BigDecimal price){
        this.description = description;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
