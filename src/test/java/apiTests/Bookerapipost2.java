package apiTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Bookerapipost2

{
	//extracting response as string
@Test
public void postboking()

{
	
	String log= RestAssured
	        .given()
	           .log()
	           .all()
	           .baseUri("https://restful-booker.herokuapp.com/")
	           .basePath("booking")
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
	           .contentType(ContentType.JSON)
	        .when()
	           .post()
	        .then()
	           .statusCode(200)
	           .extract()
	         //  .body()
	           .asPrettyString();
	 
	//.asString();
    
    
     
	System.out.println(log);
	
	
}
}