package com.example.demo.repositories;

import com.example.demo.models.MenuOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<MenuOrder, Long> {
}
