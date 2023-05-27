package com.code4fun.hackathon.mappers;

import java.util.List;

public interface GeneralMapper<DTO, E> {

    DTO toDto(E entity);


    List<DTO> toDtoList(List<E> entities);


    E toEntity(DTO dto);


    List<E> toEntityList(List<DTO> dtoList);
}
