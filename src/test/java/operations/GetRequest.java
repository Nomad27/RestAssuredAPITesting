package operations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import service.ServiceProvider;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;

public class GetRequest {

	@Test
	void getDetails() {
		
		// Specify the base url
		RestAssured.baseURI = ServiceProvider.baseURI;
		
		//validate the response
		given().get("get").then().assertThat().statusCode(200).and().body("url", equalTo("https://httpbin.org/get"))
		.body("headers.Host", equalTo("httpbin.org"))
		.header("Connection", "keep-alive");

	}

	@Test
	void getStatusCode() {
		
		// Specify the base url
		RestAssured.baseURI = ServiceProvider.baseURI;
		
		//validate the response
		given().pathParam("code", "400").when().get("status/{code}").then().assertThat().statusCode(400).and()
		.contentType(ContentType.HTML);

	}

	@Test
	void getIp() {

		RestAssured.baseURI = ServiceProvider.baseURI;
		given().get("ip").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("origin",
				is(not(equalTo(null))));

	
	}

   @Test
	void getEncoding() {

		RestAssured.baseURI = ServiceProvider.baseURI;
		given().get("encoding/utf8").then().assertThat().statusCode(200).and().contentType("text/html; charset=UTF-8");

	}


    @Test
	void getDecodedValue() {
		RestAssured.baseURI = ServiceProvider.baseURI;
		String str = "All the best";
		//Encoded the above string 
		byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
		String encodedValue = new String(bytesEncoded);
		
		// send the encoded value and verify the response
		given().pathParam("encodedVal", encodedValue).when().get("base64/{encodedVal}").then().assertThat()
		.statusCode(200).and().contentType(ContentType.HTML).and().body(equalTo(str));

	}

    @Test
	void getImage() {
		RestAssured.baseURI = ServiceProvider.baseURI;
		given().accept("image/jpeg").get("image").then().assertThat().statusCode(200).and().contentType("image/jpeg");

	}

	@Test(dataProvider = "credentials")
	public void basicAuthenticate(String usr,String pass) throws ClientProtocolException {
		RestAssured.baseURI = ServiceProvider.baseURI;

		given().auth().basic(usr, pass).get("basic-auth/test/test").then().assertThat()
		.body("authenticated", equalTo(true)).body("user", equalTo("test"));
	}
	
	@DataProvider(name="credentials")
	String [][] getCredentials(){
		
		String data[][]= {{"test","test"}};
		return(data);
		
	}
}
