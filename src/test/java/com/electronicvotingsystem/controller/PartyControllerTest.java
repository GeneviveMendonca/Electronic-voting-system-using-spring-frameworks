package com.electronicvotingsystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@WebAppConfiguration
public class PartyControllerTest 
{
	protected MockMvc mvc;
	 
	   @Autowired
	   WebApplicationContext webApplicationContext;
	   
	   @BeforeEach
	   protected void setUp() {
		      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		   }
	   
		@Test
		public void testAddParty() throws Exception {
			String uri = "/addparty";
			   MvcResult mvcResult =mvc.perform(MockMvcRequestBuilders.post(uri)
					      .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			   
			   int status =mvcResult.getResponse().getStatus();
			   assertEquals(400,status);
		}
		
		@Test
		public void testViewParty() throws Exception {
			String uri = "/viewparty/1";
			   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			   int status =mvcResult.getResponse().getStatus();
			   assertEquals(404,status);
		}
		

}
