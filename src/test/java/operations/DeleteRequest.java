package operations;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import service.ServiceProvider;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequest {

	@Test
	public void delete() throws Exception {

		// Specify the base url
		RestAssured.baseURI = ServiceProvider.baseURI;
		
		//Send the delete request and validate the response
		given().delete("delete").then().assertThat().statusCode(200).and()
				.body("url", equalTo("https://httpbin.org/delete")).body("headers.Host", equalTo("httpbin.org"))
				.header("Connection", "keep-alive");

	}

	@Test
	public void deleteAnything() throws Exception {

		// Specify the base url
		RestAssured.baseURI = ServiceProvider.baseURI;
		
		//Send the delete request and validate the response		
		given().pathParam("anything", "deletename").delete("anything/{anything}").then().assertThat().statusCode(200)
				.and().body("method", equalTo("DELETE")).body("url", equalTo("https://httpbin.org/anything/deletename"))
				.body("headers.Host", equalTo("httpbin.org")).header("Connection", "keep-alive");

	}

}
