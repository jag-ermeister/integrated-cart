package com.dish.integrated.cart.controller;

import com.dish.integrated.cart.config.TestRedisConfiguration;
import com.dish.integrated.cart.repository.Session;
import com.dish.integrated.cart.repository.SessionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRedisConfiguration.class)
@AutoConfigureMockMvc
public class SessionControllerTest {

    private ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SessionRepository sessionRepo;

    @Test
    public void creatingSessionShouldReturn201() throws Exception {
        assertEquals(0, sessionRepo.count());

        String request = "{\"zipcode\":\"80112\"}";
        ResultActions resultActions = this.mockMvc
            .perform(
                put("/session")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
            )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.zipcode", is("80112")))
            .andExpect(jsonPath("$.id", StringMatchesUUIDPattern.matchesThePatternOfAUUID()));

        MvcResult result = resultActions.andReturn();
        Session session = om.readValue(result.getResponse().getContentAsString(), Session.class);
        assertTrue(sessionRepo.findById(session.getId()).isPresent());
    }
}
