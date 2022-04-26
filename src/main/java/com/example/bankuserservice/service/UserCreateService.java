package com.example.bankuserservice.service;

import com.example.bankuserservice.dto.UserRequest;
import com.example.bankuserservice.dto.UserResponse;
import com.example.bankuserservice.mappers.UserMapper;
import com.example.bankuserservice.model.User;
import com.example.bankuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserCreateService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse execute(UserRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        User saved = userRepository.save(user);
        return userMapper.toResponse(saved);
    }
}
