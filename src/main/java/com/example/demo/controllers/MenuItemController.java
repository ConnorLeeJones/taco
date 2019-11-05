package com.example.demo.controllers;

import com.example.demo.models.MenuItem;
import com.example.demo.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/menuitems")
@CrossOrigin
public class MenuItemController {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<MenuItem>> findAll(){
        return new ResponseEntity<>(menuItemRepository.findAll(), HttpStatus.OK);

    }
}
