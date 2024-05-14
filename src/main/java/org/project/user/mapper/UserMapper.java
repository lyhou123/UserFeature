package org.project.user.mapper;

import org.mapstruct.*;
import org.project.user.domain.User;

import org.project.user.feature.user.dto.UserRequest;
import org.project.user.feature.user.dto.UserRespone;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserRespone mapToUserResponse(User user);

    User mapToUser(UserRequest userRequest);

    //update user
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromRequest(@MappingTarget User user, UserRequest userRequest);
}
