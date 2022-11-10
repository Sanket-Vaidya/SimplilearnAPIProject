package RestAPI.RestAPI2;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostUsers {

	public static HashMap<String, String> map = new HashMap<String, String>();

	UUID uuid = UUID.randomUUID();

	@Test
	public void postData() {
		map.put("name", "shivaji326");
		map.put("email", "sambhaji720" + uuid + "@yahoo.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public/v2/users";
	}



	@Test
	public void userCreation() {
		RestAssured.given().contentType("application/json").body(map)
				.header("Authorization", "Bearer 2a34c2d6931041949491bc131720682ee0e60a249ecd39dbdac9598cdc1a1e04")
				.when().post().then().log().all();
	}

}
