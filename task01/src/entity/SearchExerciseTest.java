package entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class SearchExerciseTest {

    private SearchExercise service = new SearchExercise();

    @Test
    public void getActiveOrdersTest() {
        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order2 = new Order(OrderStatus.ACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2, order3);
        assertEquals(Arrays.asList(order1, order2), service.getActiveOrders(user));
    }

    @Test
    public void getOrderByIdTest() {
        Order order1 = new Order(1);
        Order order2 = new Order(2);
        Order order3 = new Order(3);
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        assertEquals(order2, service.getOrderByIdIteration(orders, 2));
    }

    @Test
    public void getOrderByIdTest_When_id_not_found_Then_return_null() {
        Order order1 = new Order(1);
        Order order2 = new Order(2);
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(order1);
        orders.add(order2);
        assertEquals(null, service.getOrderByIdIteration(orders, 3));
    }

    @Test
    public void hasActiveOrdersTest_true() {
        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order3);
        assertEquals(true, service.hasActiveOrders(user));
    }

    @Test
    public void hasActiveOrdersTest_When_inactive_Then_return_false() {
        Order order1 = new Order(OrderStatus.INACTIVE);
        Order order3 = new Order(OrderStatus.INACTIVE);
        User user = new User(order1, order3);
        assertEquals(false, service.hasActiveOrders(user));
    }

    @Test
    public void canBeReturnedTest_When_no_items_Then_return_true() {
        OrderLine orderLine1 = new OrderLine(false);
        OrderLine orderLine2 = new OrderLine(false);
        OrderLine orderLine3 = new OrderLine(false);

        Order order = new Order(orderLine1, orderLine2, orderLine3);

        assertEquals(true, service.canBeReturned(order));
    }

    @Test
    public void canBeReturnedTest_When_item_have_SO_Then_return_false() {
        OrderLine orderLine1 = new OrderLine(false);
        OrderLine orderLine2 = new OrderLine(true);
        OrderLine orderLine3 = new OrderLine(true);

        Order order = new Order(orderLine1, orderLine2, orderLine3);

        assertFalse(service.canBeReturned(order));
    }

    @Test
    public void getMaxPriceOrderTest() {
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

        assertEquals(yavorsOrder, service.getMaxPriceOrder(yavor));
    }

    @Test
    public void getMaxPriceOrderTest_When_no_orders_Then_return_nothing() {
        User yavor = new User();
        assertEquals(null, service.getMaxPriceOrder(yavor));
    }


}