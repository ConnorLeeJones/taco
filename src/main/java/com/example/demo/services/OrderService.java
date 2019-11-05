package com.example.demo.services;

import com.example.demo.models.*;
import com.example.demo.repositories.MenuItemRepository;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private MenuItemRepository menuItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, MenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public MenuOrder newOrder(MenuOrder menuOrder){
        return orderRepository.save(menuOrder);
    }

    public Iterable<MenuOrder> findAll(){
        return orderRepository.findAll();
    }

    public MenuOrder mocko(){
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
        taco.setOrderFk(menuOrder.getOrderId());
        taco2.setOrderFk(menuOrder.getOrderId());
        menuItemRepository.save(taco);
        menuItemRepository.save(taco2);

        ArrayList<Beverage> beverages = new ArrayList<>();
        beverages.add(Beverage.COKE);
        beverages.add(Beverage.JARITTO_LIME);

        menuOrder.setItems(items);
        menuOrder.setBeverages(beverages);
        System.out.println(menuOrder);

        return this.newOrder(menuOrder);
    }

}
