package com.andigital.andservice.read.api.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.andigital.andservice.read.api.ANDServiceAPIApplicationTests;

/**
 * Created by rakeshchoudhary on 5/17/17.
 */
public class DashboardControllerTest extends ANDServiceAPIApplicationTests{
	
    @Autowired
	private WebApplicationContext context;
    
    private final ManualRestDocumentation restDocumentation = new ManualRestDocumentation("build/docs/generated-snippets");

    @BeforeMethod
	public void setUp(Method method) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(documentationConfiguration(this.restDocumentation)).build();
		this.restDocumentation.beforeTest(getClass(), method.getName());
	}
    
    @Test
    public void testDashboardApi() throws Exception{
        mockMvc.perform(get("/api/dashboard/test").contentType(MediaType.TEXT_PLAIN)).andExpect(status().isOk())
                 .andDo(print()).andExpect(content().string(containsString("Rest Service is up and running for DashBoard!!")))
                 .andDo(document("dashboard"));
    }

    /* Test for System properties API Rest Docs documentation */
    @Test
    public void shouldReturnSuccess() throws Exception {
        this.mockMvc.perform(get("/api/dashboard/systemProperties").accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andDo(document("dashboard",responseFields(
                fieldWithPath("id").description("This is MongoDB Id for System Properties."),
                fieldWithPath("last_updated_date").description("This is the System last Updated Date.")
        )));
    }
    private RestDocumentationResultHandler documentPrettyPrintReqResp(String useCase) {
        return document(useCase,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()));
    }
    @AfterMethod
	public void tearDown() {
		this.restDocumentation.afterTest();
	}
    
 }
