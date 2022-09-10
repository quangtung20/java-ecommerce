package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Role;
import com.quangtung.springdatajpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveRole(){
        User user = new User();
        user.setFirstName("ramesh");
        user.setLastName("fadatare");
        user.setEmail("ramesh@gmail.com");
        user.setPassword("secrete");

        User admin = new User();
        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");

        roleAdmin.getUsers().add(user);
        roleAdmin.getUsers().add(admin);

        user.getRoles().add(roleAdmin);
        admin.getRoles().add(roleAdmin);

        roleRepository.save(roleAdmin);
    }

    @Test
    void fetchRole(){
        List<Role> roles = roleRepository.findAll();
        roles.forEach((r) ->{
            System.out.println(r.getName());
            r.getUsers().forEach((u) ->{
                System.out.println(u.getFirstName());
            });
        });
    }

    @Test
    void findUserByEmail(){
        Optional<User> user = userRepository.findFirstByEmail("ramesh@gmail.com");
        if(!user.isPresent()){
            System.out.println("ko co");
        }

        System.out.println("user.get() = " + user.get());
        
        
        
    }
}