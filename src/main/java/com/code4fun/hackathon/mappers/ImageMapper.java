package com.code4fun.hackathon.mappers;

import com.code4fun.hackathon.domain.Image;
import com.code4fun.hackathon.domain.Mission;
import com.code4fun.hackathon.dto.ImageDto;
import com.code4fun.hackathon.dto.MissionDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper extends GeneralMapper<ImageDto, Image>{
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    ImageDto toDto(Image entity);

    Image toEntity(ImageDto dto);

    List<ImageDto> toDtoList(List<Image> entities);

    List<Image> toEntityList(List<ImageDto> dtoList);
}
