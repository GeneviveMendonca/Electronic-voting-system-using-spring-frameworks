package com.electronicvotingsystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
class ElectionControllerTest {
	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	@BeforeEach
	protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();}
   @Test
	public void  testAddElection() throws Exception {
		
		String uri = "/addelection";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		
	}
   
   @Test
   public void testViewElection() throws Exception{
	   String uri = "/viewelection/1";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			   .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = 	mvcResult.getResponse().getStatus();
	   assertEquals(404, status);
   }

}

