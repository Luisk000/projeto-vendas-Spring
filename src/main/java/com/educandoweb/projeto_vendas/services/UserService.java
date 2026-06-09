package com.educandoweb.projeto_vendas.services;

import com.educandoweb.projeto_vendas.entities.User;
import com.educandoweb.projeto_vendas.repositories.UserRepository;
import com.educandoweb.projeto_vendas.services.exceptions.DatabaseException;
import com.educandoweb.projeto_vendas.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return user.orElseThrow(() -> new ResourceNotFoundException(id));

        //Ou return repository.findById(id).get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try{
            //getReferenceById antigamente era getOne
            //A diferença para findById, é que getReferenceById apenas prepara o objeto para que seja feita uma operação, enquanto findById traz o objeto
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(User entity, User obj){
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
    }
}
