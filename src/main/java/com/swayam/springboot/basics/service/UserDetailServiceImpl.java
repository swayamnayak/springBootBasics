package com.swayam.springboot.basics.service;

import com.swayam.springboot.basics.entity.UserDetails;
import com.swayam.springboot.basics.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailsRepository userDetailRepository;

    @Override
    public UserDetails addUserDetails(UserDetails userDetails) {
        return userDetailRepository.save(userDetails);
    }

    @Override
    public List<UserDetails> getAllUserDetails() {
        return userDetailRepository.findAll();
    }

    @Override
    public List<UserDetails> getUserDetailsById(String userName) {
        return userDetailRepository.findByUserIdContainingIgnoreCase(userName);
    }

    @Override
    public void deleteUserDetailsById(String userName) {
        userDetailRepository.deleteById(userName);
    }

    @Override
    public UserDetails updateUserDetails(String userName, UserDetails userDetails) {
        UserDetails l_userDetails = userDetailRepository.findById(userName).get();

        if(Objects.nonNull(userDetails.getAddress1())
            && !"".equalsIgnoreCase(userDetails.getAddress1())) {
            l_userDetails.setAddress1(userDetails.getAddress1());
        }
        if(Objects.nonNull(userDetails.getAddress2())
                && !"".equalsIgnoreCase(userDetails.getAddress2())) {
            l_userDetails.setAddress2(userDetails.getAddress2());
        }
        if(Objects.nonNull(userDetails.getCity())
                && !"".equalsIgnoreCase(userDetails.getCity())) {
            l_userDetails.setCity(userDetails.getCity());
        }
        if(Objects.nonNull(userDetails.getCountry())
                && !"".equalsIgnoreCase(userDetails.getCountry())) {
            l_userDetails.setCountry(userDetails.getCountry());
        }
        if(Objects.nonNull(userDetails.getPinCode())
                && !"".equalsIgnoreCase(userDetails.getPinCode())) {
            l_userDetails.setPinCode(userDetails.getPinCode());
        }

        return userDetailRepository.save(l_userDetails);
    }
}
