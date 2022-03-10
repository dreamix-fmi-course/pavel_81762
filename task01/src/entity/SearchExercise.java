package entity;

import java.util.*;


public class SearchExercise {
    /**
     * extract all active orders
     * @param user
     * @return List<Order>
     */
    public ArrayList<Order> getActiveOrders(User user) {

        ArrayList<Order> activeOrders = new ArrayList<>();

        for (Order order: user.getOrders()){
            if(order.isActive()){
                activeOrders.add(order);
            }
        }
        return activeOrders;
    }

    /**
     * Return order by a specific id
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderByIdIteration(ArrayList<Order> orders, long orderId) {
        for (Order order: orders){
            if(order.getId() == orderId){
                return order;
            }
        }
        return null;
    }

    /**
     * Return orders that have specific description for item
     * @param user
     * @param description
     * @return List<Order>
     */
    public ArrayList<Order> getOrdersThatHaveItemDescription(User user, String description) {

        ArrayList<Order> withDescription = new ArrayList<>();

        for (Order order: user.getOrders()){
            ArrayList<OrderLine> l = order.getOrdersLine();
            for (OrderLine lol: l){
                if(lol.getItem().getDescription() == description){
                    withDescription.add(order);
                }
            }
        }
        return withDescription;
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {
        for (Order order: user.getOrders()){
            ArrayList<OrderLine> l = order.getOrdersLine();
            for (OrderLine lol: l){
                if(lol.getStatus() == OrderStatus.ACTIVE){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        for (OrderLine o: order.getOrdersLine()){
            if(o.isSpecialOffer()){
                return false;
            }
        }
        return true;
    }

    /**
     * Return the order with maximum total price
     * @param user
     * @return
     */
    public Order getMaxPriceOrder(User user) {
        Order maxOrder = new Order();

        for (Order order: user.getOrders()){
            if(order.totalSum().compareTo(maxOrder.totalSum()) == 1){
                maxOrder = order;
            }
        }
        return maxOrder;
    }
}
