package com.planetbug.planetbug.service;

import com.planetbug.planetbug.dto.User;
import com.planetbug.planetbug.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer createUser(User user){

        userRepository.userInsert(user.getUsername(), user.getEmail());
        return userRepository.getProcedureResult();
    }

    public Integer selectUserByUserName(User user){

        userRepository.userSelectByUserName(user.getUsername());
        return userRepository.getProcedureResult();
    }

}
