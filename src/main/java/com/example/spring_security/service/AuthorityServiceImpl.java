package com.example.spring_security.service;

import com.example.spring_security.entity.Authority;
import com.example.spring_security.repository.AuthorityRepository;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private final AuthorityRepository authorityRepository;
    private final static Logger logger = LogManager.getLogger(AuthorityServiceImpl.class);
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }


    @Override
    public void initRolesAndAuthorities() {
        if (authorityRepository.findAll().isEmpty()) {
            Authority roleUser = new Authority();
            roleUser.setAuthority("ROLE_USER");
            authorityRepository.save(roleUser);
            logger.info("Authority ROLE_USER was created");

            Authority roleAdmin = new Authority();
            roleAdmin.setAuthority("ROLE_ADMIN");
            authorityRepository.save(roleAdmin);
            logger.info("Authority ROLE_ADMIN was created");

            Authority roleManager = new Authority();
            roleManager.setAuthority("ROLE_MANAGER");
            authorityRepository.save(roleManager);
            logger.info("Authority ROLE_MANAGER was created");
        } else {
            logger.info("Authorities already initialized");
        }
    }
        //run it one time
        //then comment it out
        //or check if roles exist before creating them
    @PostConstruct
    public void init(){
        initRolesAndAuthorities();
    }

    @Override
    public List<Authority> findAllAuthorities() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority findAuthorityByName(String name) {
        return authorityRepository.findByAuthority(name);
    }

    @Override
    public Authority saveAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }
}
