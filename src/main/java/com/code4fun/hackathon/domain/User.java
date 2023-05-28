package com.code4fun.hackathon.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user", schema = "hackathon")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "account_type")
    private String accountType;

    @Basic
    @Column(name = "user_email")
    private String userEmail;

    @Basic
    @Column(name = "user_name")
    private String userName;

    @Basic
    @Column(name = "user_surname")
    private String userSurname;

    @Basic
    @Column(name = "user_nickname")
    private String userNickname;

    @Basic
    @Column(name = "user_password")
    private String userPassword;

    @Basic
    @Column(name = "user_phone_number")
    private String userPhoneNumber;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Mission> missions;
}
