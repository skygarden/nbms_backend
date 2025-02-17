package com.nexblue.nbms_backend.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nexblue.nbms_backend.web.domain.NbmsUserInf;
import com.nexblue.nbms_backend.web.mapper.NbmsUserInfMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NbmsUserInfService {

    private final NbmsUserInfMapper nbmsUserInfMapper;

    @Transactional(readOnly = true)
    public NbmsUserInf findById(String userId) {
        return nbmsUserInfMapper.findById(userId);
    }

    @Transactional(readOnly = true)
    public List<NbmsUserInf> findAll() {
        return nbmsUserInfMapper.findAll();
    }

    // @Transactional
    // public void insert(NbmsUserInf user) {
    //     nbmsUserInfMapper.insert(user);
    // }

    // @Transactional
    // public void update(NbmsUserInf user) {
    //     nbmsUserInfMapper.update(user);
    // }

    // @Transactional
    // public void delete(String userId) {
    //     nbmsUserInfMapper.delete(userId);
    // }
    
}
