package bookerapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Putrequest {
	
	
	 @Test public void pathPerimeter3() {
		  
		  RestAssured 
		  .given() 
		  .log() 
		  .all() 
		  .baseUri("https://restful-booker.herokuapp.com/")
		  .basePath("booking/3321")
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
