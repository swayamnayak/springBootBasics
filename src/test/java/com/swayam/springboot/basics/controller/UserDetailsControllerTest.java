package com.swayam.springboot.basics.controller;

import com.swayam.springboot.basics.entity.UserDetails;
import com.swayam.springboot.basics.service.UserDetailService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserDetailsController.class)
class UserDetailsControllerTest {
    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsController.class);
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserDetailService mockUserDetailService;
    private UserDetails mockUserDetails;

    @BeforeEach
    void setUp() {
        mockUserDetails = UserDetails.builder()
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
    }

    @Test
    void addUserDetails() throws Exception {
        Mockito.when(mockUserDetailService.addUserDetails(mockUserDetails))
                .thenReturn(mockUserDetails);

        mockMvc.perform(post("/adduserdetails")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\"mock.user\",\n" +
                        "    \"userType\":\"I\",\n" +
                        "    \"title\":\"Sir\",\n" +
                        "    \"firstName\":\"Mock\",\n" +
                        "    \"middleName\":\"Controller\",\n" +
                        "    \"lastName\":\"User\",\n" +
                        "    \"emailId\":\"mock@gmail.com\",\n" +
                        "    \"phone\":\"+91 9999999997\",\n" +
                        "    \"dob\":\"2022-07-15\",\n" +
                        "    \"identityNum\":\"AADHAR\",\n" +
                        "    \"address1\":\"Addr 1\",\n" +
                        "    \"address2\":\"Addr 2\",\n" +
                        "    \"city\":\"City\",\n" +
                        "    \"country\":\"INDIA\",\n" +
                        "    \"pinCode\":\"756001\",\n" +
                        "    \"lang\":\"EN\"\n" +
                        "}"))
                .andExpect(status().isOk());

    }

    @Test
    void getUserDetailsById() throws Exception {
        List<UserDetails> mockUserDetailsList = Lists.newArrayList(mockUserDetails);
        Mockito.when(mockUserDetailService.getUserDetailsById("mock.user"))
                .thenReturn(mockUserDetailsList);
        LOGGER.info("mockUserDetailsList::" + mockUserDetailsList);
        mockMvc.perform(get("/getuserdetails/mock.user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId")
                        .value(mockUserDetailsList.get(0).getUserId()));

    }
}