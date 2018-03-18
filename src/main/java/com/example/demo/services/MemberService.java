package com.example.demo.services;

import com.example.demo.domain.Member;
import com.example.demo.repositories.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService extends CrudService<Member, String, MemberRepository> {

    public MemberService(MemberRepository repository) {
        super(repository);
    }
}
