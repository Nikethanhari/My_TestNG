package getuser_list;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class Test01 {

    public int roll=5;

    // Declaration that helps to generate the logs in the test report

    private ExtentSparkReporter spark;
    private ExtentReports exten;
    private ExtentTest logger;

    @BeforeClass
    private void create_setup(){
        exten=new ExtentReports();
        spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/RecResTestExecution.html");
        exten.attachReporter(spark);
        spark.config().setDocumentTitle("web site get call validation");
        spark.config().setReportName("get api details");
        spark.config().setTheme(Theme.DARK);
        exten.setSystemInfo("QA name","Harish");
        exten.setSystemInfo("Build name","A12345");
        exten.setSystemInfo("Environment name"," DEV");
        logger=exten.createTest("Validate get api from rec application");
    }
    @Test
    public void validatewith_contain_soap() {

        logger.info("The GET API user details "+"https://reqres.in/api/users?page=2");
        Response response = get("https://reqres.in/api/users?page=2");

        String res = response.getBody().asString();
        int status_code=response.statusCode();
        logger.pass("The status code is as expected"+status_code);

        // first get count of node you want to test

        int jsonpathcount = response.getBody().jsonPath().getList("data.first_name").size();
        System.out.println("count is ==>" + jsonpathcount);

        for (int a = 0; a < jsonpathcount; a++) {
            String id = response.getBody().jsonPath().getString("data.id[" + a + "]");
            String email = response.getBody().jsonPath().getString("data.email[" + a + "]");

            System.out.println("If id value is =>" + id + " " + "Then email value is =>" + email);
            logger.info("If id value is =>" + id + " " + "Then email value is =>" + email);
        }

    }
    @AfterClass
    private void tearteam(){
        exten.flush();
    }
}
