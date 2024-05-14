package org.project.user.feature.user.service;

import lombok.RequiredArgsConstructor;
import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserRespone;
import org.project.user.feature.user.repository.UserRepository;
import org.project.user.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserRespone> getAllUsers() {

        var allUser = userRepository.findAll();
        return allUser.stream().
                map(userMapper::mapToUserResponse)
                .toList();
    }

    @Override
    public UserRespone createUser(UserRequest userRequest) {

         var user = userMapper.mapToUser(userRequest);

        return userMapper.mapToUserResponse(userRepository.save(user));

    }

    @Override
    public UserRespone updateUser(@RequestBody UserRequest userRequest, String id) {

        var useId = userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));

         userMapper.updateUserFromRequest(useId,userRequest);

        return userMapper.mapToUserResponse(userRepository.save(useId));
    }

    @Override
    public UserRespone deleteUser(String  id) {
        var userId = userRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));

        userRepository.delete(userId);

        return userMapper.mapToUserResponse(userId);
    }
}
