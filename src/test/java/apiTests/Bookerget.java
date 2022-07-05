package apiTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Bookerget
{
	//second code
    @Test
	public void getReq()
	{
		
		RestAssured
		.given()
		  .log().all()
		  .baseUri("https://restful-booker.herokuapp.com/")
          .basePath("booking/{id}")
          .pathParam("id", 3321)
		  .contentType(ContentType.JSON)
		.when()
		  .get()
		.then()
		  .assertThat()
		  .statusCode(200)
		  .log().all();
		  
		  
		  
		  
		  
		 
		
		
		
		
	}
	
	
	
}
