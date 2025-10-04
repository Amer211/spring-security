package com.example.spring_security.service;


import com.example.spring_security.entity.Authority;

import java.util.List;

public interface AuthorityService {
    void initRolesAndAuthorities();
    List<Authority> findAllAuthorities();
    Authority findAuthorityByName(String name);
    Authority saveAuthority(Authority authority);
}
