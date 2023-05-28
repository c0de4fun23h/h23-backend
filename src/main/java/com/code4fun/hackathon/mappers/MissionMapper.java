package com.code4fun.hackathon.mappers;

import com.code4fun.hackathon.domain.Mission;
import com.code4fun.hackathon.dto.MissionDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ImageMapper.class})
public interface MissionMapper extends GeneralMapper<MissionDto, Mission>{

    MissionMapper INSTANCE = Mappers.getMapper(MissionMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "image.id", target = "imageId")
    MissionDto toDto(Mission entity);

    @InheritInverseConfiguration
    Mission toEntity(MissionDto dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "image.id", target = "imageId")
    List<MissionDto> toDtoList(List<Mission> entities);

    @InheritInverseConfiguration
    List<Mission> toEntityList(List<MissionDto> dtoList);
}
