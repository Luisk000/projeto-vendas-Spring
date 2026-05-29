package com.educandoweb.projeto_vendas.services;

import com.educandoweb.projeto_vendas.entities.Order;
import com.educandoweb.projeto_vendas.entities.User;
import com.educandoweb.projeto_vendas.repositories.OrderRepository;
import com.educandoweb.projeto_vendas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> order = repository.findById(id);
        return order.get();
    }
}
