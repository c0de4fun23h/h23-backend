package com.code4fun.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginDto {

    private Long id;

    private String userName;

    private String userEmail;

    private String userPassword;
}
