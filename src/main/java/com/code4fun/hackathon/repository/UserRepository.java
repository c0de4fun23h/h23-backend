package com.code4fun.hackathon.repository;

import com.code4fun.hackathon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE user_email = :email", nativeQuery = true)
    User getUserDetails(@Param("email") String email);
}
