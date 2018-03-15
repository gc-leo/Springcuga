package com.example.demo.services;

import com.example.demo.domain.Admin;
import com.example.demo.error_handling.ResourceNotFoundException;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin getById(String id) {
        Optional<Admin> admin = adminRepository.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        }
        throw new ResourceNotFoundException("Admin with this id does not exist");

    }

    public void add(Admin admin) {
        adminRepository.insert(admin);
    }

    public void delete(String id) {
        adminRepository.deleteById(id);
    }

    public void update(Admin admin) {
        adminRepository.save(admin);
    }


}