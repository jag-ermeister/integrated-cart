package com.dish.integrated.cart.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.dish.integrated.cart.config.TestRedisConfiguration;
import com.dish.integrated.cart.repository.Session;
import com.dish.integrated.cart.repository.SessionRepository;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRedisConfiguration.class)
@AutoConfigureMockMvc
public class SessionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SessionRepository sessionRepo;

    @Test
    public void creatingSessionShouldReturn201() throws Exception {
        this.mockMvc.perform(put("/session")).andDo(print()).andExpect(status().isCreated())
                //.andExpect(content().json("{'message':[{'useRegEx':'false','hosts':'v2v2v2'}]}"));
            .andExpect(jsonPath("$.zipcode", is("90210")));
    }

    @Test
    public void blahblahblah() {
        Session sesh = new Session();
        sesh.setId("my id");
        sesh.setZipcode("90210");
        sessionRepo.save(sesh);
    }
}