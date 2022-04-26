package com.example.bankuserservice.service;

import com.example.bankuserservice.exception.UserNotFound;
import com.example.bankuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDeleteService {

    private final UserRepository userRepository;

    public void execute(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }else throw new UserNotFound();
    }
}
