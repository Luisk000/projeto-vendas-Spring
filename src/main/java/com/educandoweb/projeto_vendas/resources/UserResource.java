package com.educandoweb.projeto_vendas.resources;

import com.educandoweb.projeto_vendas.entities.User;
import com.educandoweb.projeto_vendas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    //Acessível em http://localhost:8080/users
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();

        //Retorna uma resposta, com status 200 OK, com a lista como corpo
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
