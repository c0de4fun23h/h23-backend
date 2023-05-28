package com.code4fun.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionDto {

    private Integer id;

    private String name;

    private String description;

    private BigInteger total;

    private BigInteger current;

    private Long userId;
}
