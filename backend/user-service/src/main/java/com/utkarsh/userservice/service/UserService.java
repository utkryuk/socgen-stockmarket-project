package com.utkarsh.userservice.service;

import com.utkarsh.userservice.config.CustomUserDetails;
import com.utkarsh.userservice.entity.User;
import com.utkarsh.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User createUser(User user) {
        User userToCreate = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail());

        if (userToCreate == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("user");
            user.setConfirmed(false);

            user.setEmailValidationToken(UUID.randomUUID().toString());
            return userRepository.save(user);
        }
        return null;
    }


    public User updateUser(User user, int id) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isPresent()) {
            user.setId(id);
            userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(int id) {
        Optional<User> userToDelete = userRepository.findById(id);

        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new CustomUserDetails(user);
    }

    public User activate(String token) {
        User user = userRepository.findByEmailValidationToken(token);
        if (user != null) {
            user.setConfirmed(true);
            user.setEmailValidationToken(null);
            return userRepository.save(user);
        }
        return null;
    }
}
