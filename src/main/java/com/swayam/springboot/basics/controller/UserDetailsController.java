package com.swayam.springboot.basics.controller;

import com.swayam.springboot.basics.entity.UserDetails;
import com.swayam.springboot.basics.service.UserDetailService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetailsController {
    @Autowired
    private UserDetailService userDetailService;
    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsController.class);
    @PostMapping("/adduserdetails")
    public UserDetails addUserDetails(@Valid @RequestBody UserDetails userDetails) {
        LOGGER.info("In addUserDetails()");
        return userDetailService.addUserDetails(userDetails);
    }
    @GetMapping("/getalluserdetails")
    public List<UserDetails> getAllUserDetails() {
        LOGGER.info("In getAllUserDetails()");
        return userDetailService.getAllUserDetails();
    }
    @GetMapping("/getuserdetails/{uname}")
    public List<UserDetails> getUserDetailsById(@PathVariable("uname") String userName) {
        LOGGER.info("In getUserDetailsById()");
        return userDetailService.getUserDetailsById(userName);
    }
    @DeleteMapping("/deleteuserdetails/{uname}")
    public String deleteUserDetailsById(@PathVariable("uname") String userName) {
        LOGGER.info("In deleteUserDetailsById()");
        userDetailService.deleteUserDetailsById(userName);
        return "User ["+userName+"] deleted Successfully!";
    }
    @PutMapping("/updateuserdetails/{uname}")
    public UserDetails updateUserDetails(
            @PathVariable("uname") String userName
        ,   @RequestBody UserDetails userDetails
    ) {
        LOGGER.info("In updateUserDetails()");
        return userDetailService.updateUserDetails(userName, userDetails);
    }
}
