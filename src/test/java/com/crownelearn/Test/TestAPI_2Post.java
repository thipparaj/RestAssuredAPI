package com.crownelearn.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPI_2Post {
	
	@Test
	public void testAssured()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("userId", "1");
		requestParam.put("id", "1");
		requestParam.put("title", "Sample Test title for json");
		requestParam.put("body", "Sample Test body for json");
		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		
		Response response = httpRequest.request(Method.POST,"/posts");
		response.getBody().asString();
		System.out.println(response.getBody().asString());
	}

}
