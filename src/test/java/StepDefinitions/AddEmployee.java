package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        doClick(addEmployeePage.pimTab);
    }
    @When("user clicks on add employee button")
    public void user_clicks_on_add_employee_button() {
        doClick(addEmployeePage.addEmpBtn);
    }
    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {

        sendText(addEmployeePage.firstnameTextBox, ConfigReader.getPropertyValue("firstname"));
        sendText(addEmployeePage.middlenameTextBox, ConfigReader.getPropertyValue("middlename"));
        sendText(addEmployeePage.lastnameTextBox, ConfigReader.getPropertyValue("lastname"));
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button()  {
        Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
        System.out.println("My assertion is returning true");
        doClick(addEmployeePage.saveBtn);
    }
    @When("user enters {string} and {string} and  {string}")
    public void user_enters_and_and(String fname, String mname, String lname) {
        sendText(addEmployeePage.firstnameTextBox, fname);
        sendText(addEmployeePage.middlenameTextBox, mname);
        sendText(addEmployeePage.lastnameTextBox, lname);
    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
        GlobalVariables.emp_id = addEmployeePage.empIdLocator.getAttribute("value");
        System.out.println("The employee id is: " + GlobalVariables.emp_id);
    }

    @When("query the information in backend")
    public void query_the_information_in_backend() {
        String query = "select * from hs_hr_employees where employee_id='"+ GlobalVariables.emp_id+"'";
        //to store the table coming from db, we used global variable here
        //in this variable we got all the keys and values for the employee we searched
        GlobalVariables.tabledata = DBUtility.getListOfMapsFromRset(query);
    }

    @Then("verify the results from frontend and backend")
    public void verify_the_results_from_frontend_and_backend() {
        // now from all these values we need to compare one by one value
        String firstNameFromDB=GlobalVariables.tabledata.get(0).get("emp_firstname");
        System.out.println(firstNameFromDB);
        String lastNameFromDB=GlobalVariables.tabledata.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);

        //adding assertion
        Assert.assertEquals(firstNameFromDB,"nesha");
        Assert.assertEquals(lastNameFromDB,"standart");

    }
}





