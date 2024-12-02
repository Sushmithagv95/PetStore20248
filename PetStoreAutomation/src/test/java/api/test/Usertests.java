package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class Usertests {
	Faker faker;
	User userPayload;
	
	@BeforeClass
	
	public void SetupData()
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	@Test(priority=1)
	public void testPostUser()
	{
	 Response response=UserEndPoints.CreateUser(userPayload);
	 response.then().log().all();
	 Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void testGetUser()
	{
		System.out.println("Pushed Again");
		Response response=UserEndPoints.ReadUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		

	}
	@Test(priority=3)
	public void testUpdateUser()
	{
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(),200);
		 
		 
		 //Checking Data After Update
		 
		 Response response_after_update=UserEndPoints.ReadUser(this.userPayload.getUsername());
			response_after_update.then().log().all();
			Assert.assertEquals(response_after_update.getStatusCode(),200);
	}
	
	@Test(priority=4)
	public void testDeleteUser()
	{
		Response response=UserEndPoints.DeleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
