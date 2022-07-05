package bookerapi;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Pathparameter 
{

	//firstway test
	
	  @Test public void pathPerimeter() { RestAssured .given() .log() .all()
	  .baseUri("https://restful-booker.herokuapp.com/")
	  .basePath("{basepath}/{bookingid}") .pathParam("basepath", "booking")
	  .pathParam("bookingid",3321) .contentType(ContentType.JSON) .when() .get()
	  .then() .assertThat() .statusCode(200) .log().all();
	 
		  
	}
	//second way
	
	  @Test public void pathPerimeter2() {
	  
	  RestAssured 
	  .given() 
	  .log() 
	  .all() 
	  .when()
	  .get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}",
	  "booking", 3321) 
	  .then() 
	  .statusCode(200) 
	  .log() 
	  .all();
	  
	  }
	 
	
	//third way
	

	  @Test public void pathPerimeter3() {
	  
	  Map<String,Object> pathparam= new HashMap<>();
	  
	  pathparam.put("basePath","booking"); pathparam.put("bookingId",3321);
	  
	  RestAssured .given() .log() .all()
	  .baseUri("https://restful-booker.herokuapp.com/")
	  .basePath("{basePath}/{bookingId}") .pathParams(pathparam) .when() .get()
	  .then() .statusCode(200) .log() .all();
	  
	  }
	 
	
}
