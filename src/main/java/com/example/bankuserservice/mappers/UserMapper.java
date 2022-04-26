package com.example.bankuserservice.mappers;

import com.example.bankuserservice.dto.UserRequest;
import com.example.bankuserservice.dto.UserResponse;
import com.example.bankuserservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {

    User toEntity(UserRequest userRequest);

    UserResponse toResponse(User user);

}
