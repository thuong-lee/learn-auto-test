package stepDefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class LoginApiSteps {
    String username;
    String password;
    Response response;

    @Given("input username and password")
    public void inputValidCredentials() {
        username = "thuongle";
        password = "Tuine@123";
    }

    @Given("input incorrect username and correct password")
    public void inputIncorrectUsername() {
        username = "thuongle1";
        password = "Tuine@123";
    }

    @Given("input correct username and incorrect password")
    public void inputIncorrectPassword() {
        username = "thuongle";
        password = "Tuine@1231";
    }

    @Given("input empty username and correct password")
    public void inputEmptyUsername() {
        username = "";
        password = "Tuine@123";
    }

    @Given("input correct username and empty password")
    public void inputEmptyPassword() {
        username = "thuongle1";
        password = "";
    }

    @Given("input empty username and password")
    public void inputEmptyUsernameAndPassword() {
        username = "";
        password = "";
    }

    @When("send a POST request to login api")
    public void sendPostRequest() {
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}");
        //Thực hiện phương thức post() để gửi dữ liệu đi
        response = request.when().post("/login");
        response.prettyPrint();
    }

    @Then("the response status is {int}")
    public void verifyStatusCode(int statusCode) {
        response.then().statusCode(statusCode);

    }

    @And("the response contains token")
    public void verifyResponseContainToken() {
        response.then().body("token", notNullValue());
    }


    @And("the response contains error {string}")
    public void theResponseContainsError(String errors) {
        response.then().body("errors",equalTo(errors));
    }

    @And("the response contains message {string}")
    public void theResponseContainsMessage(String message) {
        response.then().body("message",equalTo(message));
    }
}


