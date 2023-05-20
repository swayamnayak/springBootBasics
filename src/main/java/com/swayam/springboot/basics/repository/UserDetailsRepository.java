package com.swayam.springboot.basics.repository;

import com.swayam.springboot.basics.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
    public List<UserDetails> findByUserIdContainingIgnoreCase(String userName);
}
