package com.crownelearn.Test;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestAPI_DD_Post {
	
	@Test(dataProvider="empDataProvider")
	void postNewEmployee(String empName, String empSalary, String empAge)
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		
		RequestSpecification httpRequest =RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("employee_ame",empName);
		requestParams.put("employee_salary",empSalary); 
		requestParams.put("employee_age",empAge);
		//requestParams.put("employee_salary", "35000");
		//requestParams.put("employee_age", "30");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		System.out.println(httpRequest);
		
		Response httpResponse = httpRequest.request(Method.POST,"/create");
		String responseBody = httpResponse.getBody().asString();
		System.out.println(responseBody);
		
	}
	
	@DataProvider(name="empDataProvider")
	String[][] getEmpData()
	{
		String[][] empData = {{"Kumaran","35000","30"},{"raja","43000","27"}};
		return (empData);
	}

}
