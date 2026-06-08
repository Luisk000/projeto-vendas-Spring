package com.educandoweb.projeto_vendas.services;

import com.educandoweb.projeto_vendas.entities.User;
import com.educandoweb.projeto_vendas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.get();

        //Ou return repository.findById(id).get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
