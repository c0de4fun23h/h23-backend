package com.code4fun.hackathon.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "mission", schema = "hackathon")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "total")
    private BigInteger total;

    @Basic
    @Column(name = "current")
    private BigInteger current;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
