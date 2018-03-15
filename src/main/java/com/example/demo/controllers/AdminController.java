package com.example.demo.controllers;

import com.example.demo.domain.Admin;
import com.example.demo.repositories.AdminRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @ApiOperation(value = "CPOI", notes = "Get all admins by using findAll()")
    @GetMapping(value="/admins")
    public Iterable<Admin> admin() {
        return adminRepository.findAll();
    }

    @PostMapping(value="/admins")
    public String save(@RequestBody Admin admin) {
        adminRepository.save(admin);

        return admin.getId_admin();
    }

    @GetMapping( value="/admins/{id}")
    public Admin show(@PathVariable String id) {
        return adminRepository.findOne(id);
    }

    @PutMapping( value="/admins/{id}")
    public Admin update(@PathVariable String id, @RequestBody Admin admin) {
        Admin c = adminRepository.findOne(id);

        if(admin.getEmail() != null)
            c.setEmail(admin.getEmail());
        //check if profile is filled
//        if(admin.profile.getFamily_name() != null) {
////            c.setProfile(..bla,blabla)
//        }
        adminRepository.save(c);
        return c;
    }

    @DeleteMapping( value="/admins/{id}")
    public String delete(@PathVariable String id) {
        Admin admin = adminRepository.findOne(id);
        adminRepository.delete(admin);

        return "admin deleted";
    }
}
