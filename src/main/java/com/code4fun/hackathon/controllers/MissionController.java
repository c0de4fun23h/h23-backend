package com.code4fun.hackathon.controllers;

import com.code4fun.hackathon.dto.MissionDto;
import com.code4fun.hackathon.service.impl.MissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mission")
public class MissionController {

    private final MissionServiceImpl missionService;

    @RequestMapping("/create")
    public String create() {
        return "createMission";
    }

    @Autowired
    public MissionController(MissionServiceImpl missionService) {
        this.missionService = missionService;
    }

    @PostMapping
    public ResponseEntity<MissionDto> createClient(@RequestBody final MissionDto mission) {
        missionService.create(mission);
        return new ResponseEntity<>(mission, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MissionDto> updateClient(@PathVariable("id") final Long id, @RequestBody final MissionDto mission) {

        if (missionService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        missionService.update(id,mission);
        return new ResponseEntity<>(mission, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MissionDto>> getClients() {
        return new ResponseEntity<>(missionService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MissionDto> getClient(@PathVariable(name = "id") final Long id) {
        if (missionService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(missionService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MissionDto> deleteClientById(@PathVariable("id") final Long id) {
        if (missionService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        missionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
