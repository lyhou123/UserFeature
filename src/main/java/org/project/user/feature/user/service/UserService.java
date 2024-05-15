package org.project.user.feature.user.service;

import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse createUser(UserRequest userRequest);

    UserResponse updateUser(UserRequest userRequest, String id);

    UserResponse deleteUser(String id);
}
