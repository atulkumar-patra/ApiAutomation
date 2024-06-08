package com.api.stepDefinition;

import static net.serenitybdd.rest.SerenityRest.rest;

public class stepD {

	public static void main(String[] args) {

// TODO Auto-generated method stub 

		rest().given()

				.when().baseUri("https://jsonplaceholder.typicode.com/").get("posts/1/comments")

				.then().assertThat().statusCode(200);

		System.out.println("test completed");

	}

}
