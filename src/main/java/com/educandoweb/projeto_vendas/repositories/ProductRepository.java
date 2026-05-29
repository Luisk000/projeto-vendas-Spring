package com.educandoweb.projeto_vendas.repositories;

import com.educandoweb.projeto_vendas.entities.Category;
import com.educandoweb.projeto_vendas.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository não é necessário, pois o JpaRepository já a possui
public interface ProductRepository extends JpaRepository<Product, Long> {

}
