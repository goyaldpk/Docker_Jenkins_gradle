package com.andigital.andservice.read.api;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

/**
 * Created by aditeja on 5/22/2017.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ANDServiceAPIApplicationIntegrationTests extends AbstractTestNGSpringContextTests{
    //Note- Test suits for controllers to initialize below var:
    protected MockMvc mockMvc;

    //TODO: Sample Test need to remove later
    @Test
    public void contextLoads() {
        System.out.println("Sample Test class!!");
    }
}
