package com.educandoweb.projeto_vendas.repositories;

import com.educandoweb.projeto_vendas.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
