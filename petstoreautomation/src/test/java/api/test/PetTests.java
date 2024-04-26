package api.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Pet;
import api.payload.Pet.Category;
import api.payload.Pet.Tags;
import io.restassured.response.Response;

public class PetTests {
	
	Faker faker;
	Pet petPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupData() {
		
		faker=new Faker();
		petPayload=new Pet();
		
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setName(faker.animal().name());
		
		boolean isAvailable = faker.bool().bool();		
		petPayload.setStatus(isAvailable ? "available" : "not available");
		
		int numPhotoUrls = faker.random().nextInt(1, 6);
        ArrayList<String> photoUrls = new ArrayList<>();
        for (int i = 0; i < numPhotoUrls; i++) {
            photoUrls.add(faker.internet().image());
        }
        petPayload.setPhotoUrls(photoUrls);
        
        Category category = new Category(faker.number().numberBetween(1, 100), faker.animal().name());
        petPayload.setCategory(category);
        
        ArrayList<Tags> tagsList = new ArrayList<>();
        int numTags = faker.number().numberBetween(1, 4); // Generate 1 to 3 tags
        for (int i = 0; i < numTags; i++) {
            Tags tag = new Tags(faker.number().numberBetween(1, 100), faker.animal().name());
            tagsList.add(tag);
        }
        petPayload.setTags(tagsList);
		
    	logger=LogManager.getLogger(this.getClass());

	}

	
	@Test(priority=1)
	public void testPostPet() {
		
		logger.info("*******Creating Pet************");
		
		Response response=PetEndPoints.createPet(petPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*******Pet created************");

	}
	
	@Test(priority=2)
	public void testGetPetById() {
		
		logger.info("*******Reading Pet Info************");

		
		Response response=PetEndPoints.getPetById(this.petPayload.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("******* Pet Info Displayed************");

	}
	
	@Test(priority=3)
	public void testUpdatePet() {
		
		logger.info("*******Updating Pet Info************");

		petPayload.setName(faker.animal().name());
		boolean isAvailable = faker.bool().bool();		
		petPayload.setStatus(isAvailable ? "available" : "not available");
		
		Response response=PetEndPoints.updatePet(petPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*******Pet Info Updated************");
		
		Response responseAfterUpdate=PetEndPoints.getPetById(this.petPayload.getId());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
/*
	@Test(priority=4)
	public void testUpdatePetById() {
		
		logger.info("*******Updating Pet Info************");

		petPayload.setName(faker.animal().name());
		boolean isAvailable = faker.bool().bool();		
		petPayload.setStatus(isAvailable ? "available" : "not available");
		
		Response response=PetEndPoints.updatePetById(this.petPayload.getId(),petPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*******Pet Info Updated************");
		
		Response responseAfterUpdate=PetEndPoints.getPetById(this.petPayload.getId());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	*/
	
	@Test(priority=5)
	public void testDeletetPet() {
		
		logger.info("*******Pet Info Deleting************");

		
		Response response=PetEndPoints.deletePetById(this.petPayload.getId());		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*******Pet Deleted************");

	}

}
