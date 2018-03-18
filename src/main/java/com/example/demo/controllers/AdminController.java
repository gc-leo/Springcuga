package com.example.demo.controllers;

import com.example.demo.domain.Admin;
import com.example.demo.services.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(description = "admin api")
public class AdminController {


    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ApiOperation(value = "Get list of all Admins", notes = "Some notes")
    @GetMapping
    public ResponseEntity<List<Admin>> getAll() {
        return new ResponseEntity<>(adminService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get single Admin by id", notes = "Some notes")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Admin> getById(@PathVariable String id) {
        return new ResponseEntity<>(adminService.getById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create cpoi", notes = "Some notes")
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Admin cPoi) {
        adminService.add(cPoi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete cpoi", notes = "Some notes")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        adminService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update cpoi", notes = "Some notes")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Admin cPoi) {
        adminService.update(cPoi);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

