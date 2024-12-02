package api.endpoints;

public class Routes {
	
	/*Urls
	
	CreateUser(POST) : https://petstore.swagger.io/v2/user
	Get User(GET): https://petstore.swagger.io/v2/user/{username}
	Update User (PUT) : https://petstore.swagger.io/v2/user/{username}
	Delete User (DEL) : https://petstore.swagger.io/v2/user/{username}
	
	
	
	*/
	
	
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String del_url=base_url+"/user/{username}";
	

}