package operations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import service.ServiceProvider;

import org.apache.commons.httpclient.HttpStatus;

public class PostRequest {

	@Test
	void postData() {
		// get the base URI
		RestAssured.baseURI = ServiceProvider.baseURI;
		//Validate the response
		given().post("post").then().assertThat().statusCode(200).and().body("url", equalTo("https://httpbin.org/post"))
		.body("headers.Host", equalTo("httpbin.org"));
	}

	@Test
	void postStatus() {

		RestAssured.baseURI = ServiceProvider.baseURI;
		given().pathParam("code", "400").when().post("status/{code}").then().assertThat().statusCode(400);
		
		//get the error message based on the code
		String responseMessage = HttpStatus.getStatusText(HttpStatus.SC_BAD_REQUEST);
		System.out.println(responseMessage);

	}

}
