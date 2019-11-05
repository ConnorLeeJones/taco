package com.example.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MenuOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany
    @JoinColumn(name = "orderFk")
    private List<MenuItem> items;

    private ArrayList<Beverage> beverages;

    public MenuOrder() {
    }

    public MenuOrder(ArrayList<MenuItem> items, ArrayList<Beverage> beverages) {
        this.items = items;
        this.beverages = beverages;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = beverages;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
}
