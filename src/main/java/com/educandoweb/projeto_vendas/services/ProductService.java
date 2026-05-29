package com.educandoweb.projeto_vendas.services;

import com.educandoweb.projeto_vendas.entities.Category;
import com.educandoweb.projeto_vendas.entities.Product;
import com.educandoweb.projeto_vendas.repositories.CategoryRepository;
import com.educandoweb.projeto_vendas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> product = repository.findById(id);
        return product.get();
    }
}
