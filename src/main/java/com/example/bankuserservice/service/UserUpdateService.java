package com.example.bankuserservice.service;

import com.example.bankuserservice.dto.UserRequest;
import com.example.bankuserservice.dto.UserResponse;
import com.example.bankuserservice.exception.UserNotFound;
import com.example.bankuserservice.mappers.UserMapper;
import com.example.bankuserservice.model.User;
import com.example.bankuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserUpdateService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse execute(UUID id, UserRequest userRequest) {
        User saved = userRepository.findById(id).orElseThrow(UserNotFound::new);
        BeanUtils.copyProperties(saved, userRequest);
        User updated = userRepository.save(saved);
        return userMapper.toResponse(updated);
    }
}


