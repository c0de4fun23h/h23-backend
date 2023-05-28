package com.code4fun.hackathon.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.Instant;

@Entity
@Table(name = "mission")
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

    @Basic
    @Column(name = "create_date")
    @CreationTimestamp
    private Instant createdOn;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;


}
