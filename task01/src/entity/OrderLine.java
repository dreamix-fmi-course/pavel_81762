package entity;

/**
 * Create OrderLine which holds information for:
 * Item, enum for status, boolean specialOffer and count
 * Implement setters/getters/constructor
 */

public class OrderLine {
    private Item item;
    private OrderStatus status;
    private boolean specialOffer;
    private int qty;

    OrderLine(Item item, OrderStatus status, boolean specialOffer, int qty){
        this.item = item;
        this.specialOffer = specialOffer;
        this.qty = qty;
        this.status = status;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public int getQty() {
        return qty;
    }

    public Item getItem() {
        return item;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
