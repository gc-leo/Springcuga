package com.example.demo.controllers;

import com.example.demo.domain.Coin;
import com.example.demo.services.CoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/coin")
@Api(description = "coin api")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @ApiOperation(value = "Get list of all Coins", notes = "Some notes")
    @GetMapping
    public ResponseEntity<List<Coin>> getAll() {
        return new ResponseEntity<>(coinService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get single Coin by id", notes = "Some notes")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Coin> getById(@PathVariable String id) {
        return new ResponseEntity<>(coinService.getById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create coin", notes = "Some notes")
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Coin cPoi) {

        coinService.add(cPoi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete coin", notes = "Some notes")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        coinService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update coin", notes = "Some notes")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Coin cPoi) {
        coinService.update(cPoi);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
