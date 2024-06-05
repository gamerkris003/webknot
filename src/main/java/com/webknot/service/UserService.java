package com.webknot.service;

import com.webknot.dto.SignUpRequest;
import com.webknot.entity.User;

public interface UserService {
    void createUser(SignUpRequest signUpRequest);
    boolean existsByUsername(String username);
    User findByUsername(String username);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
