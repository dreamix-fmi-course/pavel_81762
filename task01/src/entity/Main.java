package entity;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Item basketball = new Item("you can shoot hoops", new BigDecimal(29.99));
        Item flower = new Item("Happy woman's day", new BigDecimal(5.66));
        Item monitor = new Item("Watch games on it", new BigDecimal(129.99));
        Item iphone = new Item("Steve jobs invented me", new BigDecimal(1299.00));
        Item mouse = new Item("With side buttons for playing WOW", new BigDecimal(27.99));

        OrderLine phone = new OrderLine(iphone, OrderStatus.INACTIVE, false, 2);
        OrderLine asusMonitor = new OrderLine(monitor, OrderStatus.INACTIVE, true, 1);
        OrderLine razerMouse = new OrderLine(mouse, OrderStatus.ACTIVE, true, 3);
        OrderLine topki = new OrderLine(basketball, OrderStatus.ACTIVE, true, 2);

        Order yavorsOrder = new Order(phone, asusMonitor, razerMouse);
        Order yavorSecondOrder = new Order(topki, phone);

        User yavor = new User("yavor", 23, yavorsOrder, yavorSecondOrder);

        System.out.println(yavorsOrder.totalSum());
        System.out.println(yavor.totalOrderPrice());

        System.out.println(yavor);

        System.out.println();
    }
}
