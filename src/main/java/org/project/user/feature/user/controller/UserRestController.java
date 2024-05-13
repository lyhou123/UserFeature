package org.project.user.feature.user.controller;

import lombok.RequiredArgsConstructor;
import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserRespone;
import org.project.user.feature.user.repository.UserRepository;
import org.project.user.feature.user.service.UserService;
import org.project.user.mapper.UserMapper;
import org.project.user.utils.BaseRespone;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService service;

    @GetMapping
    public BaseRespone<List<UserRespone>> getUser()
    {
        return BaseRespone.<List<UserRespone>>readSuccess()
                .setPayload(service.getAllUsers());
    }

    @PostMapping
    public BaseRespone<UserRespone> createUser(@RequestBody UserRequest userRequest)
    {
              return BaseRespone.<UserRespone>createSuccess()
                      .setPayload(service.createUser(userRequest));
    }


    @PutMapping("/{id}")
    public BaseRespone<UserRespone> updateUser(@RequestBody UserRequest userRequest,@PathVariable Long id)
    {
        return BaseRespone.<UserRespone>updateSuccess()
                .setPayload(service.updateUser(userRequest,id));
    }

    @DeleteMapping("/{id}")
    public BaseRespone<UserRespone> deleteUser(@PathVariable Long id)
    {
        return BaseRespone.<UserRespone>deleteSuccess()
                .setPayload(service.deleteUser(id));
    }


}
