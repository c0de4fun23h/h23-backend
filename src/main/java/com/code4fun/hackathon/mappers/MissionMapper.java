package com.code4fun.hackathon.mappers;

import com.code4fun.hackathon.domain.Mission;
import com.code4fun.hackathon.dto.MissionDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface MissionMapper extends GeneralMapper<MissionDto, Mission>{

    @Mapping(source = "user.id", target = "userId")
    MissionDto toDto(Mission entity);

    @InheritInverseConfiguration
    Mission toEntity(MissionDto dto);

    @Mapping(source = "user.id", target = "userId")
    List<MissionDto> toDtoList(List<Mission> entities);

    @InheritInverseConfiguration
    List<Mission> toEntityList(List<MissionDto> dtoList);
}
