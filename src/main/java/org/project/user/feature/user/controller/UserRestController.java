package org.project.user.feature.user.controller;
import lombok.RequiredArgsConstructor;
import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserResponse;
import org.project.user.feature.user.service.UserService;
import org.project.user.utils.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService service;

    @GetMapping
    public BaseResponse<List<UserResponse>> getUser()
    {
        return BaseResponse.<List<UserResponse>>readSuccess()
                .setPayload(service.getAllUsers());
    }

    @PostMapping
    public BaseResponse<UserResponse> createUser(@RequestBody UserRequest userRequest)
    {
              return BaseResponse.<UserResponse>createSuccess()
                      .setPayload(service.createUser(userRequest));
    }


    @PutMapping("/{id}")
    public BaseResponse<UserResponse> updateUser(@RequestBody UserRequest userRequest, @PathVariable String id)
    {
        return BaseResponse.<UserResponse>updateSuccess()
                .setPayload(service.updateUser(userRequest,id));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<UserResponse> deleteUser(@PathVariable String id)
    {
        return BaseResponse.<UserResponse>deleteSuccess()
                .setPayload(service.deleteUser(id));
    }

}
