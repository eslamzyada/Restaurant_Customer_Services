/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant_customerservices;

/**
 *
 * @author MS
 */
public class MenuOrders {
    private String orders;
    private double price;
    private int orderId;

    public MenuOrders(String orders, double price) {
        this.orders = orders;
        this.price = price;
    }

    public MenuOrders(String orders, double price, int orderId) {
        this.orders = orders;
        this.price = price;
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
    

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
