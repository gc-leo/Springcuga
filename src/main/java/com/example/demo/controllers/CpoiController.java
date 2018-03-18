package com.example.demo.controllers;

import com.example.demo.domain.Cpoi;
import com.example.demo.services.CpoiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cpoi")
@Api(description = "cpoi api")
public class CpoiController {

    private CpoiService cpoiService;

    public CpoiController(CpoiService cpoiService) {
        this.cpoiService = cpoiService;
    }

    @ApiOperation(value = "Get list of all Cpois", notes = "Some notes")
    @GetMapping
    public ResponseEntity<List<Cpoi>> getAll() {
        return new ResponseEntity<>(cpoiService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get single Cpoi by id", notes = "Some notes")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cpoi> getById(@PathVariable String id) {
        return new ResponseEntity<>(cpoiService.getById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create cpoi", notes = "Some notes")
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Cpoi cPoi) {

        cpoiService.add(cPoi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete cpoi", notes = "Some notes")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        cpoiService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update cpoi", notes = "Some notes")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cpoi cPoi) {
        cpoiService.update(cPoi);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
