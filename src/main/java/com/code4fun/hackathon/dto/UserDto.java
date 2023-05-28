package com.code4fun.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;

    private String accountType;

    private String userEmail;

    private String userName;

    private String userSurname;

    private String userNickname;

    private String userPassword;

    private String userPhoneNumber;

    private List<MissionDto> missions;


}
