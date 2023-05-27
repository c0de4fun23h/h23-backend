package com.code4fun.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionDto {

    private Integer id;

    private String name;

    private String description;

    private Long userId;
}
