package com.educandoweb.projeto_vendas.repositories;

import com.educandoweb.projeto_vendas.entities.OrderItem;
import com.educandoweb.projeto_vendas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository não é necessário, pois o JpaRepository já a possui
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
