Feature: API workflow for HRMS


Background:
  Given a JWT is generated





  @api
  Scenario: create an employee using API call
    Given a request i prepared to create an employee
    When a Post call is made to create an employee
    Then  the status code for creating an employee is 201
    Then the employee contains key ""Message" and values "Employee Created"
    Then the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

