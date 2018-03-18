package com.example.demo.services;

import com.example.demo.error_handling.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public class CrudService<T, ID, R extends MongoRepository<T, ID>> {

    private R repository;

    public CrudService(R repository) {
        this.repository = repository;
    }

    public Page<T> getAll(Pageable pageable) {
        return repository.findAll(pageable);
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
