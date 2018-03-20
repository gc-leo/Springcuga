package com.example.demo.controllers;

import com.example.demo.domain.Cpoi;
import com.example.demo.domain.Location;
import com.example.demo.external_api.weather_api.domain.Weather;
import com.example.demo.services.CpoiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<Page<Cpoi>> getAll(Pageable pageable) {
        return new ResponseEntity<>(cpoiService.getAll(pageable), HttpStatus.OK);
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

    @ApiOperation(value = "Get weather for Cpoi", notes = "Some notes")
    @GetMapping(value = "/weather/{id}")
    public ResponseEntity<Weather> getWeatherForCpoi(@PathVariable String id) {
        return new ResponseEntity<>(cpoiService.getWeatherForCpoi(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Get near by cpois by location", notes = "Some notes")
    @PostMapping(value = "/nearby")
    public ResponseEntity<List<Cpoi>> nearBy(@RequestBody Location location, @RequestParam(value = "radius", required = false) Float radius){
        if(radius == null)
            return new ResponseEntity<>(cpoiService.nearBy(location.getLat(), location.getLon(), (float)0.55091), HttpStatus.OK);

        return new ResponseEntity<>(cpoiService.nearBy(location.getLat(), location.getLon(), radius), HttpStatus.OK);
    }

}
