package com.example.spring_security.repository;


import com.example.spring_security.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.jaas.JaasPasswordCallbackHandler;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {


    Authority findByAuthority(String authority);
}
