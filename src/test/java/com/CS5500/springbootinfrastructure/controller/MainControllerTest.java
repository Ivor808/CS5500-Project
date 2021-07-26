package com.CS5500.springbootinfrastructure.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@Import(MainController.class)
class MainControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void addNewDateLog() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.post("/dateLog").param("caloriesIdle","15");
    MvcResult result = mvc.perform(request).andReturn();
    //shouldnt return anything since we are mocking
    assertEquals(result.getResponse().getContentAsString(),"Saved");
  }

  @Test
  void getAllDates() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("/dateLog");
    MvcResult result = mvc.perform(request).andReturn();
    //shouldnt return anything since we are mocking
    assertEquals(result.getResponse().getContentLengthLong(),0.0);
  }

  @Test
  void getAllActivity() {
  }

  @Test
  void getAllMove() {
  }

  @Test
  void getAllType() {
  }

  @Test
  void getAllPlace() {
  }
}