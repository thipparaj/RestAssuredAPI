package com.crownelearn.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPI_1 
{
	@Test
	public void testing()
	{
		
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/posts/1");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		String statusTitle = response.toString();
		Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", 
				"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		System.out.println(statusTitle);
		
		
		
	/*RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	RequestSpecification httprequest = RestAssured.given();
	
	Response httpresponse = httprequest.request(Method.GET, "/posts/1");
	
	String responseBody = httpresponse.getBody().asString();
	System.out.println(responseBody);
	
	
	
	int statusCode = httpresponse.getStatusCode();
	System.out.println(statusCode);
	String satusLine = httpresponse.getStatusLine();
	System.out.println(satusLine);*/
	}

}
