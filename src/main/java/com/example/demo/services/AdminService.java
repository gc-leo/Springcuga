package com.example.demo.services;

import com.example.demo.domain.Admin;
import com.example.demo.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends CrudService<Admin, String, AdminRepository> {

    public AdminService(AdminRepository repository) {
        super(repository);
    }
}