package com.example.demo.services;

import com.example.demo.domain.Member;
import com.example.demo.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService extends CrudService<Member, String, MemberRepository> {

    public MemberService(MemberRepository repository) {
        super(repository);
    }

    public Member findMemberByNameAndPassword(String username, String password){

        Optional<Member> user = getRepository().findMemberByNameAndCredentials_Password(username, password);
        if(!user.isPresent()){
            return null;
        }
        else return user.get();
    }
}
