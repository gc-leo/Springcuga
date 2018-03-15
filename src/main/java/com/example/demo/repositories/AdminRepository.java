package com.example.demo.repositories;

import com.example.demo.domain.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {

    public Admin findAdminByEmail(String email);

}