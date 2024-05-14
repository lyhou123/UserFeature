package org.project.user.feature.user.controller;
import lombok.RequiredArgsConstructor;
import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserRespone;
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
    public BaseResponse<List<UserRespone>> getUser()
    {
        return BaseResponse.<List<UserRespone>>readSuccess()
                .setPayload(service.getAllUsers());
    }

    @PostMapping
    public BaseResponse<UserRespone> createUser(@RequestBody UserRequest userRequest)
    {
              return BaseResponse.<UserRespone>createSuccess()
                      .setPayload(service.createUser(userRequest));
    }


    @PutMapping("/{id}")
    public BaseResponse<UserRespone> updateUser(@RequestBody UserRequest userRequest, @PathVariable String id)
    {
        return BaseResponse.<UserRespone>updateSuccess()
                .setPayload(service.updateUser(userRequest,id));
    }

    @DeleteMapping("/{id}")
    public BaseResponse<UserRespone> deleteUser(@PathVariable String id)
    {
        return BaseResponse.<UserRespone>deleteSuccess()
                .setPayload(service.deleteUser(id));
    }

}
