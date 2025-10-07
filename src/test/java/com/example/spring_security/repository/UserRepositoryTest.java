package com.example.spring_security.repository;

import com.example.spring_security.entity.Authority;
import com.example.spring_security.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        //clear the database
        userRepository.deleteAll();

        //create authority
        Authority authority = new Authority();
        authority.setAuthority("ROLE_USER");

        User user = new User();
        user.setUsername("amer211");
        user.setPassword("Admin123");
        user.setAuthorities(Set.of(authority));
        userRepository.save(user);
    }


    @Test
    void ItShouldFindByUsername() {
        Optional<User> userOptional = userRepository.findByUsername("amer211");
        assertTrue(userOptional.isPresent(), "User should be present");
        assertNotNull(userOptional.get().getUserId(), "User ID should not be null");
        User user = userOptional.get();
        assertEquals("amer211", user.getUsername());
    }
    @Test
    void itShouldNotFindByUsername(){
        Optional<User> userOptional = userRepository.findByUsername("nonexistent");
        assertFalse(userOptional.isPresent(), "User should not be present");
    }






}