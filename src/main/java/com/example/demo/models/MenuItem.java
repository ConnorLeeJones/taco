package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MenuItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private Meat meat;
    private HashSet<Condiment> condiments;
    private Long orderFk;

    public MenuItem() {}

    public MenuItem(Meat meat, HashSet<Condiment> condiments) {
        this.meat = meat;
        this.condiments = condiments;
    }


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public HashSet<Condiment> getCondiments() {
        return condiments;
    }

    public void setCondiments(HashSet<Condiment> condiments) {
        this.condiments = condiments;
    }


    public Long getOrderFk() {
        return orderFk;
    }

    public void setOrderFk(Long orderFk) {
        this.orderFk = orderFk;
    }
}
