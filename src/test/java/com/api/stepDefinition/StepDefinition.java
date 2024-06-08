package com.api.stepDefinition;

import static net.serenitybdd.rest.SerenityRest.given;

import static net.serenitybdd.rest.SerenityRest.rest;

import static net.serenitybdd.rest.SerenityRest.then;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.HashMap;

import java.util.List;

import java.util.Properties;

import org.hamcrest.Matchers;

import com.api.model.PostMethod;

import com.api.model.baseClass;

import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.PendingException;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import io.restassured.response.Response;

import io.restassured.path.json.JsonPath;

public class StepDefinition {

//mapper class 

	ObjectMapper mapper;

	public String endpoint;

//response class 

	public static Response getMethod_response;

	public static Response postMethod_response;

	public static Response deleteMethod_response;

//pojo class 

	PostMethod pmClass;

//endpoint 

//	public static String Uri = "https://jsonplaceholder.typicode.com"; 

//	public static String getMethod_endpoint = "https://jsonplaceholder.typicode.com/posts/1/comments"; 

//	public static String postMethod_endpoint = "https://jsonplaceholder.typicode.com/posts/"; 

//	public static String deleteMethod_endpoint = "https://jsonplaceholder.typicode.com/posts/1"; 

	public static Properties prop = new Properties();

	public static String url1;

//////////////////////////////////////////////////////////////////////////////

	@Given("User using GET method initializes the {string}")

	public void user_using_get_method_initializes_the(String endPoint) throws Throwable {

		System.out.println("Initializing the EndPoint...");

		url1 = baseClass.setProperties();

//System.out.println(url1); 

		this.endpoint = endPoint;

		getMethod_response = given()

				.when().baseUri(url1).get(endpoint);

	}

	@When("User using GET method validates the {int} and Response file")

	public void user_using_get_method_validates_the_and_response_file(Integer statusCode) {

		System.out.println("Validating the Status Code...");

		getMethod_response.then().statusCode(statusCode);

	}

	@Then("User using GET method get the Response file")

	public void user_using_get_method_get_the_response_file() {

		System.out.println("Getting the Response File...");

		System.out.println("Response :");

		System.out.println(getMethod_response.asString());

//json 

		System.out.println("Calculating Number of Results...");

		JsonPath json1 = getMethod_response.jsonPath();

		List<String> idCount = json1.get("postId");

		System.out.println("Total count : ");

		System.out.print(idCount.size());

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Given("User using POST method initializes the {string}")

	public void user_using_post_method_initializes_the(String endPoint)
			throws JsonParseException, JsonMappingException, IOException {

		System.out.println("Initializing the EndPoint...");

		url1 = baseClass.setProperties();

//set json path 

		String strJsonBody = "src/test/java/json/postmethod.json";

//mapper class 

		mapper = new ObjectMapper();

//map json and pojo class 

		pmClass = mapper.readValue(new File(strJsonBody), PostMethod.class);

//set endpoint 

		this.endpoint = endPoint;

		postMethod_response = given().contentType("application/json")

				.header("charset", "UTF-8")

				.body(mapper.writeValueAsString(pmClass))

				.when().baseUri(url1).post(endpoint);

	}

	@When("User using POST method validates the {int} and Response file")

	public void user_using_post_method_validates_the_and_response_file(Integer statusCode) {

		System.out.println("Validating the Status Code...");

		postMethod_response.then().statusCode(statusCode);

	}

	@Then("User using POST method get the Response file")

	public void user_using_post_method_get_the_response_file() {

		System.out.println("Getting the Response File...");

		System.out.println("Response :");

		System.out.println(postMethod_response.asString());

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Given("User using DELETE method initializes the {string}")

	public void user_using_delete_method_initializes_the(String endPoint) throws Throwable {

		System.out.println("Initializing the EndPoint...");

		url1 = baseClass.setProperties();

		this.endpoint = endPoint;

		deleteMethod_response = given()

				.when().baseUri(url1).delete(endpoint);

	}

	@When("User using DELETE method validates the {int} and Response file")

	public void user_using_delete_method_validates_the_and_response_file(Integer statusCode) {

		System.out.println("Validating the Status Code...");

		deleteMethod_response.then().statusCode(statusCode);

	}

	@Then("User using DELETE method get the Response file")

	public void user_using_delete_method_get_the_response_file() {

		System.out.println("Getting the Response File...");

		System.out.println("Response :");

		System.out.println(deleteMethod_response.asString());

		try {

			HashMap<String, String> IDCount = deleteMethod_response.jsonPath().get("id");

//			System.out.println("Total count : "); 

			System.out.print(IDCount.size());

		}

		catch (Exception e) {

			System.out.println("Exception" + e);

//System.out.println(""); 

		}

	}

}
