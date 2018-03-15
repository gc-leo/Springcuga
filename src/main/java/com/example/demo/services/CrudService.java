package com.example.demo.services;

import com.example.demo.domain.Admin;
import com.example.demo.error_handling.ResourceNotFoundException;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class CrudService<T, ID, R extends MongoRepository<T, ID>> {

    @Autowired
    private R repository;

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getById(ID id) {
        Optional<T> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        throw new ResourceNotFoundException("Admin with this id does not exist");

    }

    public void add(T entity) {
        repository.insert(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    public void update(T entity) {
        repository.save(entity);
    }

}
