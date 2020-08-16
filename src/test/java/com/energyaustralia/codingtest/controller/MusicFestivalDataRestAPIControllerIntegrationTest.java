package com.energyaustralia.codingtest.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.energyaustralia.codingtest.EnergyAustraliaCodingTestApplication;



@SpringBootTest(classes = EnergyAustraliaCodingTestApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
public class MusicFestivalDataRestAPIControllerIntegrationTest {
	
	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void testAllEAMusicFestivals() 
    {
        assertTrue(
                this.restTemplate
                    .getForObject("http://localhost:" + port + "/api/v1/eamusicfestivals", String.class)
                    .length() >0);
    }

	
	

}
