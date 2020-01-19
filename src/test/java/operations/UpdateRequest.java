package operations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import service.ServiceProvider;

public class UpdateRequest {

	@Test
	void putDetails() {
		//Specify the base uri
		RestAssured.baseURI = ServiceProvider.baseURI;
		
		//Send the request and verify the response
		given().put("put").then().assertThat().statusCode(200).and().body("url", equalTo("https://httpbin.org/put"))
		.body("headers.Host", equalTo("httpbin.org")).header("Connection", "keep-alive");

	}

}
