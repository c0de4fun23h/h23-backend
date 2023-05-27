package com.code4fun.hackathon.service.impl;

import com.code4fun.hackathon.domain.User;
import com.code4fun.hackathon.dto.UserDto;
import com.code4fun.hackathon.repository.UserRepository;
import com.code4fun.hackathon.service.AbstractService;
import com.code4fun.hackathon.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<UserDto, User, Integer, UserRepository, UserMapper> {


    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }
}
