package com.tnas.gsbbackend.controllers;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	
	private static final String API_URL = "/api/v1/users";
	
    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Rule
    public TestWatcher watchman = TestWatchman.watchman;

    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
        TestWatchman.watchman.registerClass(UserControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(UserControllerTest.class);
    }

    @Test
    @Order(1)
    public void whenGettingEmptyUsersList_ThenSuccess() throws Exception {
    	
        var usersList = mockMvc.perform(MockMvcRequestBuilders.get(API_URL))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        Assert.assertEquals("[]", usersList);
    }
    
    @Test
    @Order(2)
    public void whenAddingOneUserAndGettingList_ThenSuccessOneElementList() throws Exception {
    	
    	var jsonUser = "{\"id\":1,\"firstName\":\"Thiago\",\"lastName\":\"Nascimento\",\"email\":\"nascimenthiago@gmail.com\"}";
    	
        mockMvc.perform(MockMvcRequestBuilders.post(API_URL)
        			.contentType(MediaType.APPLICATION_JSON).content(jsonUser))
            .andExpect(MockMvcResultMatchers.status().isOk());
        
        var usersList = mockMvc.perform(MockMvcRequestBuilders.get(API_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assert.assertEquals("[" + jsonUser + "]", usersList);
    }

}
