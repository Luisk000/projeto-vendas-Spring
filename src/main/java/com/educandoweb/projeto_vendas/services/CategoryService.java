package com.educandoweb.projeto_vendas.services;

import com.educandoweb.projeto_vendas.entities.Category;
import com.educandoweb.projeto_vendas.entities.Order;
import com.educandoweb.projeto_vendas.repositories.CategoryRepository;
import com.educandoweb.projeto_vendas.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> category = repository.findById(id);
        return category.get();
    }
}
