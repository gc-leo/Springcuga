package com.example.demo.controllers;

import com.example.demo.domain.Member;
import com.example.demo.services.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
@Api(description = "member api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "Get list of all Members", notes = "Some notes")
    @GetMapping
    public ResponseEntity<List<Member>> getAll() {
        return new ResponseEntity<>(memberService.getAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get single Member by id", notes = "Some notes")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Member> getById(@PathVariable String id) {
        return new ResponseEntity<>(memberService.getById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create member", notes = "Some notes")
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Member cPoi) {

        memberService.add(cPoi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete member", notes = "Some notes")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Update member", notes = "Some notes")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Member cPoi) {
        memberService.update(cPoi);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
