package com.code4fun.hackathon.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.Instant;

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

    private Instant createdOn;

    private Long userId;

    private Long imageId;
}
