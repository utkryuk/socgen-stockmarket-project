package com.utkarsh.userservice.repository;

import com.utkarsh.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByUsernameOrEmail(String username, String email);

    User findByEmailValidationToken(String token);
}
