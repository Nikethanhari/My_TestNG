package getuser_list;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import reusable.RecuresJsonbody;


public class CreateNewUser {

    RecuresJsonbody RJB;

    @BeforeClass

    public void setup(){

        RJB = new RecuresJsonbody();

    }

    @Parameters({"usercreationurl","ssno","username"})
    @Test(groups = {"smoke"},priority = 5)
    public void create_new_user(String usercreationurl,String ssno,String username){

        Response res=given().contentType(ContentType.JSON).
                body(RJB.CreateUserJsonBody(ssno,username))
                .when()
                .post(usercreationurl);
        int Status_code = res.getStatusCode();
        String response_body=res.getBody().asString();
        System.out.println(Status_code);
        System.out.println(response_body);
        String user_id=res.getBody().jsonPath().getString("id");
        System.out.println("The user id is "+user_id);

    }

    @Parameters({"url1","Celsius"})
    @Test (groups = {"E2E testing"})
    public void create_new_cels_value(String url1,String Celsius){

        Response res=given().header("Content-Type","text/xml; charset=utf-8").
                body(RJB.user_create_the_conversion_request_body(Celsius))
                .when()
                .post(url1);
        int Status_code = res.getStatusCode();
        String response_body=res.getBody().asString();
        System.out.println(Status_code);
        System.out.println(response_body);
        //user_id=res.getBody().jsonPath().getString("id");
        //System.out.println("The user id is "+user_id);

    }

    @Test(groups = {"smoke"},priority = 0)
    public void test_the_scenario1(){
        System.out.println("The test scenario1 is executed");
    }

    @Test (groups = {"regression"})
    public void test_the_scenario2(){
        System.out.println("The test scenario2 is executed");
    }

    @Test(groups = {"sanity"})
    public void test_the_scenario3(){
        System.out.println("The test scenario3 is executed");
    }

    @AfterClass

    public void teardown(){

    }
}
