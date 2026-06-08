package com.educandoweb.projeto_vendas.resources;

import com.educandoweb.projeto_vendas.entities.User;
import com.educandoweb.projeto_vendas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //@RequestBody para que user seja o body da requisição
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{ID}").buildAndExpand(user.getId()).toUri();
        //Retorna 201 CREATED em caso de sucesso
        return ResponseEntity.created(uri).body(user);
    }

    //@PathVariable faz com que o id seja uma variável da url
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
