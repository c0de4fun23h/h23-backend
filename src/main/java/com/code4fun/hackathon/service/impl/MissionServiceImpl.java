package com.code4fun.hackathon.service.impl;

import com.code4fun.hackathon.domain.Mission;
import com.code4fun.hackathon.dto.MissionDto;
import com.code4fun.hackathon.service.AbstractService;
import com.code4fun.hackathon.mappers.MissionMapper;
import com.code4fun.hackathon.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionServiceImpl extends AbstractService<MissionDto, Mission, Long, MissionRepository, MissionMapper> {
    @Autowired
    public MissionServiceImpl(MissionRepository repository, MissionMapper mapper) {
        super(repository, mapper);
    }
}
