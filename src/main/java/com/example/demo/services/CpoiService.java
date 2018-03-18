package com.example.demo.services;

import com.example.demo.domain.Cpoi;
import com.example.demo.repositories.CpoiRepository;
import org.springframework.stereotype.Service;

@Service
public class CpoiService extends CrudService<Cpoi, String, CpoiRepository> {

    public CpoiService(CpoiRepository repository) {
        super(repository);
    }
}
