package com.nexblue.nbms_backend.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nexblue.nbms_backend.web.domain.NbmsUserInf;

@Mapper
public interface NbmsUserInfMapper {
    NbmsUserInf findById(String userId);
    List<NbmsUserInf> findAll();
    // void insert(NbmsUserInf user);
    // void update(NbmsUserInf user);
    // void delete(String userId);
}