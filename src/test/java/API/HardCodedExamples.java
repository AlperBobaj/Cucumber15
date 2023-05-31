package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {


   String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
   String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzE0NDksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxNDY0OSwidXNlcklkIjoiNTQ5MiJ9.hD0sGy8W_Q2-F2QzUx7qcmoFJ9jfw_zFlTPzzZ190Jk";
   static String employee_id;

   @Test
   public void getCreateEmployee(){
       RequestSpecification preparedRequest = given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id",employee_id);


       //hitting the  endpoint
       Response response=preparedRequest.when().get("/getOneEmployee.php");
       response.prettyPrint();
       //verify the response
       response.then().assertThat().statusCode(200);

       String tempEmpId= response.jsonPath().getString("employee.employee_id");

       //we have 2 emp id,one is global and second is local
       Assert.assertEquals(employee_id,tempEmpId);
   }
     @Test
   public void createEmployee(){
       //prepare the request

      RequestSpecification preparedRequest =given().
              header("Content-Type","application/json").
              header("Authorization",token).body("{\n" +
                      "  \"emp_firstname\": \"Alper\",\n" +
                      "  \"emp_lastname\": \"Bobaj\",\n" +
                      "  \"emp_middle_name\": \"mega\",\n" +
                      "  \"emp_gender\": \"M\",\n" +
                      "  \"emp_birthday\": \"1990-05-21\",\n" +
                      "  \"emp_status\": \"engiiner\",\n" +
                      "  \"emp_job_title\": \"QA\"\n" +
                      "}");
       //hitting the endpoint
     Response response = preparedRequest.when().post("/createEmployee.php");
//it will print the output in the console
         response.prettyPrint();
         //verifying the assertions/get response
      response.then().assertThat().statusCode(201);
      // we are capturing employee if from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
      response.then().assertThat().body("Employee.emp_firstname",equalTo("Alper"));
      response.then().assertThat().body("Employee.emp_lastname",equalTo("Bobaj"));

      //verify the response headers
         response.then().assertThat().header("Content-Type","application/json");


        //in homework,create a method to get ll employee status and job title


         }

         @Test
         public void cupdateEmployee(){
       RequestSpecification preparedRequest = given().
               header("Content-Type","application/json").
               header("Authorization",token).body("{\n" +
                       "  \"employee_id\": \""+employee_id+"\",\n" +
                       "  \"emp_firstname\": \"alper\",\n" +
                       "  \"emp_lastname\": \"bobaj\",\n" +
                       "  \"emp_middle_name\": \"gaga\",\n" +
                       "  \"emp_gender\": \"M\",\n" +
                       "  \"emp_birthday\": \"1990-05-21\",\n" +
                       "  \"emp_status\": \"Enginier\",\n" +
                       "  \"emp_job_title\": \"QA\"\n" +
                       "}");

       //hitting the endpoint
             Response response = preparedRequest.when().put("/updateEmployee.php");
             response.then().assertThat().statusCode(200);

             //for verification
             response.then().assertThat().body("Message",equalTo("Employee record Updated"));



   }
   @Test
    public void dgetUpdatedEmployee(){
       RequestSpecification preparedRequest = given().
               header("Content-Type","application/json").
               header("Authorization",token).
               queryParam("employee_id",employee_id);

       Response response=preparedRequest.when().get("/getOneEmployee.php");
       response.prettyPrint();

       response.then().assertThat().statusCode(200);
       // if you want to verify the body of the response
       // you can do that using hamcrest matchers
   }
         }
