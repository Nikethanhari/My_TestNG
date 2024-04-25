package getuser_list;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.get;

public class Getusers {

    @BeforeClass
    public void setup(){
        System.out.println("i am before the class");

    }
    @Test
    public void do_reqres_get_userlist_vaildation(){

        System.out.println("i am inside the test ");
        Response response=get("https://reqres.in/api/users?page=2");
        String status_code=String.valueOf(response.statusCode());
        Assert.assertEquals(status_code,"200");
        System.out.println(response.getBody().asString());
    }

    @AfterClass
    public void close_the_connection(){

        System.out.println("iam close the connection");

    }

    @Test
    public void booklibary_Soap_call_vaildation(){

        System.out.println("this is book library ");
    }
}
