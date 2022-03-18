package entity;

import java.math.BigDecimal;
import java.util.ArrayList;

public class User {
    private ArrayList<Order> orders;
    private String name;
    private int age;

    User(String name, int age, Order ...orders){
        this.name = name;
        this.age = age;
        this.orders = new ArrayList<>();
        for (Order l: orders){
            this.orders.add(l);
        }
    }

    User(Order ...orders){
        this.orders = new ArrayList<>();
        for (Order l: orders){
            this.orders.add(l);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "orders=" + orders +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public BigDecimal totalOrderPrice(){
        BigDecimal total = new BigDecimal(0);
        for (Order order: orders){
            total = total.add(order.totalSum());
        }
        return total;
    }

}
