package com.example.demo.services;

import com.example.demo.domain.Admin;
import com.example.demo.error_handling.ResourceNotFoundException;
import com.example.demo.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService extends CrudService<Admin, String, AdminRepository> {

}