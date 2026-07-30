package com.polteq.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sum() throws Exception {
        mockMvc.perform(get("/sum").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void Multiply() throws Exception {
        mockMvc.perform(get("/multiply").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }

    @Test
    void divide() throws Exception {
        mockMvc.perform(get("/divide").param("a", "6").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    void subtract() throws Exception {
        mockMvc.perform(get("/subtract").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void power() throws Exception {
        mockMvc.perform(get("/power").param("a", "2").param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("1024.0"));
    }

    @Test
    void sqrt() throws Exception {
        mockMvc.perform(get("/sqrt").param("a", "9"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    void modulo() throws Exception {
        mockMvc.perform(get("/modulo").param("a", "7").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void average() throws Exception {
        mockMvc.perform(get("/average").param("numbers", "2,4,6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4.0"));
    }

    @Test
    void factorial() throws Exception {
        mockMvc.perform(get("/factorial").param("n", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("120"));
    }
}
