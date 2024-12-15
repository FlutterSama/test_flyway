package com.ideanet.test_flyway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideanet.test_flyway.domain.User;
import com.ideanet.test_flyway.service.UserService;
import com.ideanet.test_flyway.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserService userService;

    UserServiceImpl userServiceImp;

    @Autowired
    ObjectMapper objectMapper;

    void testAllWithName(){

    }


    @Test
    void testAll() throws Exception {
        List<User> userList = Arrays.asList(
                new User("MgMg","mgmg@gmail.com"),
                new User("KyawKyaw","kyawkyaw@gmail.com"),
                new User("ZawZaw","zawzaw@gmail.com"),
                new User("MgMg","mgmg@gmail.com")
        );

        given(userService.getUsers()).willReturn(userList);

        mockMvc.perform(get("/api/v1/user/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name",is("MgMg")))
                .andExpect(jsonPath("$.length()",is(4)));
    }



}
