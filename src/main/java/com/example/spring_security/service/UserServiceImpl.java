package com.example.spring_security.service;

import com.example.spring_security.entity.Authority;
import com.example.spring_security.entity.User;
import com.example.spring_security.repository.AuthorityRepository;
import com.example.spring_security.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private  final AuthorityRepository authorityRepository;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        if(userRepository.findByUsername(user.getUsername())!=null){
            logger.warn("User with username {} already exists ", user.getUsername());
            throw new RuntimeException("User with username "+ user.getUsername()+" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Authority userAuthority = authorityRepository.findByAuthority("ROLE_USER");
        user.getAuthorities().add(userAuthority);

        logger.info("User with username {} was created ", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
        logger.info("User with id {} was deleted ", id);

    }

    @Override
    public User updateUser(Long id, User user) {
        return null;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
