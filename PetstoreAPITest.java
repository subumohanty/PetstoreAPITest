package petstore_api_test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PetstoreAPITest {

    // Define the base URL for the Petstore API
    private String baseUrl = "https://petstore.swagger.io/v2";

    // Test the GET /pet/{petId} endpoint
    @Test
    public void testGetPetById() {
        int petId = 1; // Replace with the pet ID you want to test
        String endpoint = "/pet/" + petId;

        Response response = RestAssured.get(baseUrl + endpoint);

        if (response.getStatusCode() == 200) {
            System.out.println("GET /pet/" + petId + " - Pet found: " + response.getBody().asString());
        } else {
            System.out.println("GET /pet/" + petId + " - Pet not found");
        }
    }

    // Test the GET /store/inventory endpoint
    @Test
    public void testGetInventory() {
        String endpoint = "/store/inventory";

        Response response = RestAssured.get(baseUrl + endpoint);

        if (response.getStatusCode() == 200) {
            System.out.println("GET /store/inventory - Inventory: " + response.getBody().asString());
        } else {
            System.out.println("GET /store/inventory - Failed to retrieve inventory");
        }
    }

    // Test the POST /store/order endpoint
    @Test
    public void testPlaceOrder() {
        String endpoint = "/store/order";

        // Define your order data as a JSON string
        String orderData = "{\"petId\": 1, \"quantity\": 1, \"shipDate\": \"2023-11-10T10:00:00Z\"}";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(orderData)
                .post(baseUrl + endpoint);

        if (response.getStatusCode() == 200) {
            System.out.println("POST /store/order - Order placed: " + response.getBody().asString());
        } else {
            System.out.println("POST /store/order - Failed to place order");
        }
    }
}

