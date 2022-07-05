package apiTests;


import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Multiplebookings 



{
	 
	 RequestSpecification reqspec;
	
	@BeforeClass()
		public void common() {
			
			reqspec=RestAssured.given();
			reqspec.log()
	           .all()
	           .baseUri("https://restful-booker.herokuapp.com/")
	           .basePath("booking")
	           .contentType(ContentType.JSON);
					
		}
		
	
	@Test
	public void bookin1()
	{
		
		 RestAssured
		        .given()
		        .spec(reqspec)
		          .body("{\r\n"
		           		+ "    \"firstname\" : \"Jim\",\r\n"
		           		+ "    \"lastname\" : \"Brown\",\r\n"
		           		+ "    \"totalprice\" : 111,\r\n"
		           		+ "    \"depositpaid\" : true,\r\n"
		           		+ "    \"bookingdates\" : {\r\n"
		           		+ "        \"checkin\" : \"2018-01-01\",\r\n"
		           		+ "        \"checkout\" : \"2019-01-01\"\r\n"
		           		+ "    },\r\n"
		           		+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
		           		+ "}")
		           
		        .when()
		           .post()
		        .then()
		           .statusCode(200)
		           .log()
		           .all();		
		
	}
	@Test
	public void bookin2()
	{
		
		RestAssured
		.given()
		.spec(reqspec)
		  .header("Content-Type","application/json")
		  .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		  .body("{\r\n"
	           		+ "    \"firstname\" : \"Sree\",\r\n"
	           		+ "    \"lastname\" : \"Brown\",\r\n"
	           		+ "    \"totalprice\" : 111,\r\n"
	           		+ "    \"depositpaid\" : true,\r\n"
	           		+ "    \"bookingdates\" : {\r\n"
	           		+ "        \"checkin\" : \"2018-01-01\",\r\n"
	           		+ "        \"checkout\" : \"2019-01-01\"\r\n"
	           		+ "    },\r\n"
	           		+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
	           		+ "}")
		  .when()
		  .put()
		  .then() 
		  .assertThat()
		  .statusCode(200) 
		  .log() 
		  .all();
		
		
	}
	
	
	
	
	}


