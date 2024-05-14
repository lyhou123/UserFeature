package org.project.user.feature.user.service;

import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserRespone;

import java.util.List;

public interface UserService {
    List<UserRespone> getAllUsers();

    UserRespone createUser(UserRequest userRequest);

    UserRespone updateUser(UserRequest userRequest, String id);

    UserRespone deleteUser(String id);
}
