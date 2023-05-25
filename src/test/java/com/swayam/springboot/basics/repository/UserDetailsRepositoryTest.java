package com.swayam.springboot.basics.repository;

import com.swayam.springboot.basics.entity.UserDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserDetailsRepositoryTest {
    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsRepositoryTest.class);
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        UserDetails mockUserDetails = UserDetails.builder()
                .userId("mock.user")
                .userType("I")
                .title("Sir")
                .firstName("Mock")
                .middleName("Repo")
                .lastName("User")
                .emailId("mock.user@mailg.com")
                .phone("987654321")
                .dob(new Date(new java.util.Date().getTime()))
                .identityNum("VOTER ID")
                .address1("Address A")
                .address2("Address B")
                .city("City")
                .country("India")
                .pinCode("100001")
                .lang("EN")
                .build();

        testEntityManager.persist(mockUserDetails);
    }

    @Test
    public void whenFindById_thenReturnUserDetails() {
        UserDetails userDetails = userDetailsRepository
                .findByUserIdContainingIgnoreCase("mock.user").get(0);
        LOGGER.info("repo userDetails::" + userDetails);
        assertEquals(userDetails.getFirstName(), "Mock");
    }
}