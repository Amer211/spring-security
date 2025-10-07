package com.example.spring_security.config;

import com.example.spring_security.entity.User;
import com.example.spring_security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        System.out.println("Authorities for username: " + username + " are: " + userOptional.get().getAuthorities());
        userOptional.get().getAuthorities().forEach(a -> System.out.println(a + " | " + a.getClass().getName()));

        return new CustomUserDetails(userOptional.get());
    }
}
