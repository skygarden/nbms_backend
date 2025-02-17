package com.nexblue.nbms_backend.web.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NbmsUserInf {
    String compCd;
    String userId;
    String userNm;
    String passId;
    String hqCd;
    String armCd;
    String deptCd;
    String positionCd;
    String rankCd;
    String empId;
    String email;
    String hpNo;
    String workSts;
    String useYn;
    String authLv;
    LocalDateTime createDate;
    String createUser;
    LocalDateTime updateDate;
    String updateUser;
}
