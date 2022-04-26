package com.example.bankuserservice.service;

import com.example.bankuserservice.dto.UserResponse;
import com.example.bankuserservice.exception.UserNotFound;
import com.example.bankuserservice.mappers.UserMapper;
import com.example.bankuserservice.model.User;
import com.example.bankuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserGetService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserResponse execute(UUID id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFound::new);
        return userMapper.toResponse(user);
    }

    public Page<UserResponse> execute(Pageable pageable) {
         return userRepository.findAll(pageable).map(userMapper::toResponse);
    }


}
