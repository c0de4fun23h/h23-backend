package com.code4fun.hackathon.mappers;

import com.code4fun.hackathon.domain.User;
import com.code4fun.hackathon.dto.UserDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MissionMapper.class})
public interface UserMapper extends GeneralMapper<UserDto, User>{

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "missions", target = "missions")
    UserDto toDto(User entity);

    @InheritInverseConfiguration
    @Mapping(target = "missions", ignore = true)
    User toEntity(UserDto dto);


    @IterableMapping(qualifiedByName = "forDtoList")
    List<UserDto> toDtoList(List<User> entityList);

    @IterableMapping(qualifiedByName = "forEntityList")
    List<User> toEntityList(List<UserDto> dtoList);

    @Named("forDtoList")
    default UserDto forDtoList(User entity) {
        return toDto(entity);
    }

    @Named("forEntityList")
    default User forEntityList(UserDto dto) {
        return toEntity(dto);
    }
}
