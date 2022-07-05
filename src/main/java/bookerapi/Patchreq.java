package bookerapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Patchreq {
	
	
	 @Test public void pathPerimeter4() {
		  
		  RestAssured 
		  .given() 
		  .log() 
		  .all() 
		  .baseUri("https://restful-booker.herokuapp.com/")
		  .basePath("booking/4891")
		  .header("Content-Type","application/json")
		  .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		  .body("'{\r\n"
		  		+ "    \"firstname\" : \"Jim\",\r\n"
		  		+ "    \"lastname\" : \"Brow\"\r\n"
		  		+ "}'")
		  .when()
		  .patch()
		  .then() 
		  .assertThat()
		  .statusCode(200) 
		  .log() 
		  .all();
		  
		  }


}
