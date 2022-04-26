package com.example.bankuserservice.controller;

import com.example.bankuserservice.dto.UserRequest;
import com.example.bankuserservice.dto.UserResponse;
import com.example.bankuserservice.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(
        value = "api/v1/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class UserController {

    private final UserCreateService userCreateService;
    private final UserGetService userGetService;
    private final UserDeleteService userDeleService;
    private final UserUpdateService userUpdateService;


    @GetMapping("")
    public Page<UserResponse> getAll(Pageable pageable) {
        return userGetService.execute(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(userGetService.execute(id));
    }

    @PostMapping(
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userCreateService.execute(userRequest);
        return ResponseEntity.created(
                linkTo(methodOn(UserController.class).getById(userResponse.getId())).toUri()
        ).body(userResponse);
    }

    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserResponse> update(
            @Valid @RequestBody UserRequest userRequest,
            @PathVariable("id") UUID id
    ) {
        UserResponse userResponse = userUpdateService.execute(id, userRequest);
        return ResponseEntity.created(
                linkTo(methodOn(UserController.class).getById(userResponse.getId())).withSelfRel().toUri()
        ).body(userResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID uuid) {
        userDeleService.execute(uuid);
        return ResponseEntity.notFound().build();
    }


}
