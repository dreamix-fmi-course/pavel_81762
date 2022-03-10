package entity;

/*
Structure:
User {List<Order>}
    Order {enum Status ; List<OrderLine> ; LocalDate ; enum PaymentMethod}
        OrderLine { enum ; Item ;  }
            Item { String }
        PaymentMethod


Order of implementation: Item -> OrderList -> PaymentMethod -> Order -> User
tl;dr: User holds basket(list of Orders). Order holds list of OrderLine. OrderLine hold the item product

/** Create class Order that implements
 * id, status:OrderStatus, List<OrderLine> orderLines, creationDate, totalPrice, paymentMethod,
 * deliveryDueDate, user
 *
 * Implements constructors: default, by status, by id, by array of lines (use ...)
 * getters, setters, toString, isActive
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int id;
    private OrderStatus status;
    private ArrayList<OrderLine> orders;
    private Date creationDate;
    private BigDecimal totalPrice;
    private Date deliveryDate;
    private User user;

    public Order(){
        id = -1;
        status = null;
        orders = new ArrayList<OrderLine>();
        creationDate = null;
        totalPrice = new BigDecimal(0) ;
        deliveryDate = null;
        user = null;
    }

    public Order(OrderLine ...orders) {
        this.orders = new ArrayList<OrderLine>();
        for (OrderLine l: orders){
            this.orders.add(l);
        }
        this.totalPrice = new BigDecimal(0);
    }

    public Order(OrderStatus status){
        this.status = status;
    }

    public Order(int id, OrderStatus status, ArrayList<OrderLine> orders, Date creationDate, BigDecimal totalPrice, Date deliveryDate, User user) {
        this.id = id;
        this.status = status;
        this.orders = orders;
        this.creationDate = creationDate;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.user = user;
    }

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ArrayList<OrderLine> getOrdersLine() {
        return orders;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setOrders(ArrayList<OrderLine> orders) {
        this.orders = orders;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orders=" + orders +
                ", creationDate=" + creationDate +
                ", totalPrice=" + totalPrice +
                ", deliveryDate=" + deliveryDate +
                ", user=" + user +
                '}';
    }

    public BigDecimal totalSum(){
        for (int i = 0; i < orders.size(); i++){
            this.totalPrice = this.totalPrice.add(orders.get(i).getItem().getPrice().multiply(new BigDecimal(orders.get(i).getQty())));
        }
        return totalPrice;
    }

    public boolean isActive(){
        return this.status == OrderStatus.ACTIVE;
    }
}
