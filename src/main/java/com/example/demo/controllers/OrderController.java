package com.example.demo.controllers;

import com.example.demo.models.MenuOrder;
import com.example.demo.repositories.MenuItemRepository;
import com.example.demo.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/orders")
@CrossOrigin
public class OrderController {

    private OrderService orderService;
    private MenuItemRepository menuItemRepository;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Iterable<MenuOrder>> findAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MenuOrder> createOrder(@RequestBody MenuOrder menuOrder) {
        return new ResponseEntity<>(orderService.newOrder(menuOrder), HttpStatus.OK);
    }

    @PostMapping("/mocko")
    public ResponseEntity<MenuOrder> mocko() {
        return new ResponseEntity<>(orderService.mocko(), HttpStatus.OK);
    }
}
