package com.example.demo.repositories;

import com.example.demo.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {

    Optional<Member> findMemberByNameAndCredentials_Password(String name, String password);

}
