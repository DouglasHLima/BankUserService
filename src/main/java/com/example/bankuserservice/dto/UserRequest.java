package com.example.bankuserservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRequest {
    private String cpf;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String login;
}
