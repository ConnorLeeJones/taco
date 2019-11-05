package com.example.demo;

import com.example.demo.controllers.OrderController;
import com.example.demo.models.*;
import com.example.demo.services.OrderService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class MenuOrderTest {



    private OrderService orderService;

    private OrderController orderController;

    @Before
    public void setUp() {
        orderController = new OrderController(orderService);
    }

    @Test
    public void orderTest(){
        Taco taco = new Taco();
        HashSet<Condiment> condiments = new HashSet<>();
        condiments.add(Condiment.CHEESE);
        condiments.add(Condiment.JALEPENO);
        condiments.add(Condiment.LETTUCE);
        condiments.add(Condiment.LIME);
        taco.setCondiments(condiments);
        taco.setMeat(Meat.CHICKEN);
        Taco taco2 = new Taco();
        taco2.setMeat(Meat.FISH);

        MenuOrder menuOrder = new MenuOrder();
        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(taco);
        items.add(taco2);

        ArrayList<Beverage> beverages = new ArrayList<>();
        beverages.add(Beverage.COKE);
        beverages.add(Beverage.JARITTO_LIME);

        menuOrder.setItems(items);
        menuOrder.setBeverages(beverages);

        this.orderController.createOrder(menuOrder);
    }
}
