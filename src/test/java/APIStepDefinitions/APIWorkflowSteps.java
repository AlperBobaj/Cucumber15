package APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIWorkflowSteps {

    RequestSpecification request;
    Response response;
    public static String employee_id;

    @Given("a request i prepared to create an employee")
    public void a_request_i_prepared_to_create_an_employee() {
      
    }

    @When("a Post call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the status code for creating an employee is {int}")
    public void the_status_code_for_creating_an_employee_is(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}