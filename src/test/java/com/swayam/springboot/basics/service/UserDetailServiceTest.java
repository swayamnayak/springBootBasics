package com.swayam.springboot.basics.service;
import java.sql.Date;
import java.util.List;

import com.swayam.springboot.basics.entity.UserDetails;
import com.swayam.springboot.basics.repository.UserDetailsRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailServiceTest {
    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceTest.class);
    @Value("${user.mock.flag}")
    private boolean isMocked;
    @Autowired
    private UserDetailService userDetailService;
    @MockBean
    private UserDetailsRepository userDetailsRepository;

    @BeforeEach
    void setUp() {
        UserDetails mockUserDetails = UserDetails.builder()
                .userId("mock.user")
                .userType("I")
                .title("Sir")
                .firstName("Mock")
                .middleName("")
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

        List<UserDetails> userDetailsList = Lists.newArrayList(mockUserDetails);
        Mockito.when(userDetailsRepository.findByUserIdContainingIgnoreCase("mock.user"))
                .thenReturn(userDetailsList);
    }

    @Test
    @DisplayName("Get Mocked User details")
    public void whenUserNotFound_thenSetMockUserDetails() {
        LOGGER.info("Mock Flag is " + isMocked);
        String userId = "mock.user";
        UserDetails userDetailsFound = userDetailService.getUserDetailsById(userId).get(0);
        LOGGER.info("service userDetails::" + userDetailsFound);
        //assertTrue(isMocked, "Mocking is enabled!");
        assertEquals(userId, userDetailsFound.getUserId());
    }
}