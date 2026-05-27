package com.educandoweb.projeto_vendas.resources;

import com.educandoweb.projeto_vendas.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //Acessível em http://localhost:8080/users
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "mria@gmail.com", "99999999", "12345");

        //Retorna uma resposta, com status 200 OK, com o User u como corpo
        return ResponseEntity.ok().body(u);
    }
}
