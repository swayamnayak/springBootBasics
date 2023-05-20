package com.swayam.springboot.basics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
public class User {
    @Id
    private String userName;
    private String userPassword;
    private String userDescription;
    private Date creationDate;
    private Date lastUpdated;
    private Date pwdExpiryDate;
    private String createdBy;
    private String lastUpdatedBy;
    private int lockCounter;
    private String lockStatus;
    private String lockReason;
    private String forceChangePwd;
    private String inactiveStatus;
    private String inactiveReason;
    private int objectVersionNum;
}
