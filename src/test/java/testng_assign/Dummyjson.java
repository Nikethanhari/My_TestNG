package testng_assign;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Dummyjson {

    @Test
    public void testAPIResponse() {
        // Set base URI
        RestAssured.baseURI = "https://dummyjson.com/products/1";


        System.out.println(baseURI);

        // Make a GET request and store the response
             Response response = RestAssured.given().get(baseURI);
            System.out.println("Response: " + response.jsonPath().get("images"));


        // Get status code from the response
          int statusCode = response.getStatusCode();

        // Verify status code is 200
        Assert.assertEquals(statusCode, 200, "Status code is 200");

        // Get the response body as a string
        String responseBody = response.getBody().asString();

        String title = response.getBody().jsonPath().getString("title");
        System.out.println("The title value is " + title);
        String price_value = response.getBody().jsonPath().getString("price");
        System.out.println("Validate the price value" + price_value);
        String brand_value = response.getBody().jsonPath().getString("brand");
        System.out.println("Validate the brand value"  + brand_value);
        String images = response.getBody().jsonPath().getString("images");
        System.out.println("Validate total image count"+images);

        //List<String> images = response.jsonPath().getList("images");
        //Assert.assertEquals(images.size(), 5, "Total images count is not 5");

    }
}