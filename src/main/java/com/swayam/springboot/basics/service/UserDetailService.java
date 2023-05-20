package com.swayam.springboot.basics.service;

import com.swayam.springboot.basics.entity.UserDetails;

import java.util.List;

public interface UserDetailService {
    public UserDetails addUserDetails(UserDetails userDetails);

    public List<UserDetails> getAllUserDetails();

    public List<UserDetails> getUserDetailsById(String userName);

    public void deleteUserDetailsById(String userName);

    public UserDetails updateUserDetails(String userName, UserDetails userDetails);
}
