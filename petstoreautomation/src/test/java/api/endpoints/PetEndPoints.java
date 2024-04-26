package api.endpoints;

import java.util.ResourceBundle;
import static io.restassured.RestAssured.given;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static ResourceBundle getURL() {
		
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
		
	}
	
	public static Response createPet(Pet payload) {
		
		String post_url=getURL().getString("post_url_pet");
		
		Response response= given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
						.when()
							.post(post_url);
		return response;
		
	}
	
	public static Response getPetById(int id) {

		String get_url=getURL().getString("get_url_pet");

		
		Response response = given()
								.pathParam("petId", id)
							.when()
								.get(get_url);

		return response;
	}
	
	
	public static Response updatePet(Pet payload) {
		
		String update_url=getURL().getString("update_url_pet");
		
		Response response= given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
						.when()
							.put(update_url);
		return response;
		
	}

/*	public static Response updatePetById(int id,Pet payload) {
		
		String update_url=getURL().getString("post_url_pet_id");
		
		Response response= given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
						 	.pathParam("petId", id)
							.body(payload)
						.when()
							.post(update_url);
		return response;
		
	}
	*/
	
	public static Response deletePetById(int id) {

		String delete_url=getURL().getString("delete_url_pet");

		
		Response response = given()
								.pathParam("petId", id)
							.when()
								.delete(delete_url);

		return response;
	}

}
