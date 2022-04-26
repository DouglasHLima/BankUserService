package com.example.bankuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private UUID id;
    private String cpf;
    private String name;
    private LocalDateTime creation;
    private LocalDateTime update;
}
