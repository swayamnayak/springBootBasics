package com.swayam.springboot.basics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetails {
    @Id
    private String userId;
    @NotBlank(message = "Please add Usertype")
    private String userType;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    @NotBlank(message = "Please add email id")
    @Email
    private String emailId;
    private String phone;
    private Date dob;
    private String identityNum;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String pinCode;
    private String lang;
}
