package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import api.payload.User;
public class UserEndPoints {

	
	public static Response CreateUser(User Payload)
	{
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(Payload)
		
		.when()
			.post(Routes.post_url);
	return response;
	}
	public static Response ReadUser(String Username)
	{
		System.out.println("BATMAN " + Username);
		Response response=given()
			.pathParam("username",Username)	
		
		.when()
			.get(Routes.get_url);
	return response;
	}
	public static Response UpdateUser(String Username,User Payload)
	{
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(Payload)
			.pathParam("username",Username)
		
		.when()
			.put(Routes.put_url);
	return response;
	}
	public static Response DeleteUser(String Username)
	{
		Response response=given()
			.pathParam("username",Username)
		
		.when()
			.delete(Routes.del_url);
	return response;
	}
	
}
