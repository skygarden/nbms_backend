package com.nexblue.nbms_backend.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.nexblue.nbms_backend.web.domain.NbmsUserInf;
import com.nexblue.nbms_backend.web.service.NbmsUserInfService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NbmsUserInfController {

    public final NbmsUserInfService nbmsUserInfService;

    @GetMapping("/user/{id}")
    public NbmsUserInf findById(@PathVariable("id") String userId) {
        return nbmsUserInfService.findById(userId);
    }

    @GetMapping("/user")
    public List<NbmsUserInf> findAll() {
        return nbmsUserInfService.findAll();
    }

    // @PostMapping("/user")
    // public void insert(NbmsUserInf user) {
    //     nbmsUserInfService.insert(user);
    // }

    // @PutMapping("/user")
    // public void update(@RequestBody NbmsUserInf user) {
    //     nbmsUserInfService.update(user);
    // }

    // @DeleteMapping("/user/{id}")
    // public void delete(@PathVariable("id") String userId) {
    //     nbmsUserInfService.delete(userId);
    // }
}
