package com.educandoweb.projeto_vendas.resources;

import com.educandoweb.projeto_vendas.entities.Order;
import com.educandoweb.projeto_vendas.entities.User;
import com.educandoweb.projeto_vendas.services.OrderService;
import com.educandoweb.projeto_vendas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable long id) {
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
