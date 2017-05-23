package com.andigital.andservice.read.api.controller;

import com.andigital.andservice.read.api.ANDServiceAPIApplicationIntegrationTests;
import com.andigital.andservice.read.api.ANDServiceAPIApplicationTests;
import com.jayway.restassured.response.Response;
import org.junit.Assert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Rest Assured Integration Test class
 *
 */
public class DashboardControllerIntegrationTest extends ANDServiceAPIApplicationTests {


	@LocalServerPort
	private int port;

	/**
	 * Sample Test for Dashboard test API
	 */

	@Test
	public void testDashboardApi() throws Exception {
		given().port(port).contentType(MediaType.TEXT_PLAIN_VALUE).when().get("/and-services/api/dashboard/test").then()
				.statusCode(200);
	}

	// When a POST call is made
	@Test
	public void postTestNegative() {
		given().port(port).contentType(MediaType.APPLICATION_JSON_VALUE).
				when().post("/and-services/api/dashboard/systemProperties").
				then().statusCode(405);
	}
	// When different content type is given
	@Test
	public void contentTypePositive() {
		given().port(port).contentType(MediaType.TEXT_XML_VALUE).
				when().get("/and-services/api/dashboard/systemProperties").
				then().statusCode(200);
	}
	// Response not null test
	@Test
	public void lastUpdatedDateResponseNotNullTest() {
		Response res = given().port(port).contentType(MediaType.APPLICATION_JSON_VALUE).
				when().get("/and-services/api/dashboard/systemProperties").
				then().statusCode(200).body(containsString("last_updated_date")).extract().response();
		Assert.assertNotNull(res.getBody().jsonPath().getString("last_updated_date"));
		Assert.assertTrue(!res.asString().isEmpty());
		Assert.assertTrue(res.asString().length() > 0);
	}
}
