package com.example.springProject.initializers;

import com.example.springProject.user.User;
import com.example.springProject.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Creating student user
        User studentUser = new User();
        studentUser.setUsername("student");
        studentUser.setPassword(passwordEncoder.encode("1234"));
        studentUser.setRoles(Set.of("STUDENT"));
        userRepository.save(studentUser);

        // Creating professor user
        User professorUser = new User();
        professorUser.setUsername("professor");
        professorUser.setPassword(passwordEncoder.encode("1234"));
        professorUser.setRoles(Set.of("PROFESSOR"));
        userRepository.save(professorUser);

//        User user = new User();
//        user.setUsername("user");
//        user.setPassword(passwordEncoder.encode("password"));
//        userRepository.save(user);
    }
}

