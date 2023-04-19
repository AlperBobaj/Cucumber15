Feature: Login Functionalities

  @smoke1
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And  click on login button
    Then user is logged in successfully
   # And Close the browser


  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And  click on login button
    Then user is logged in successfully
  # And Close the browser


   @ScenarioOutline:
  #Parameterization/Data Driven
  Scenario Outline: Login with multiple credentials using Scenario Outline
   #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And  click on login button
    Then user is logged in successfully
  # And Close the browser
  Examples:
    | username | password    |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |

     @dataTable
    Scenario: Login with multiple credentials using date table
  When  user enters username and password and verifies login
    | username | password    |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |
  #data Table


    #If you want to use parameterization
#If you wish to implement data driven testing
  # Scenario Outline is always used along with the keyword 'Examples'



  #coment
  #Hooks: For defining pre and post steps in any Cucumber framework
  #     : This always created inside the StepDefinitions folder
  #     : Hooks will take care of pree and post conditions irrespective
  #      :of what goes in between the test steps

  #BACKGROUND: Its the clubbing of common steps in different scenarios of a feature file
  #            till flow is not broken
  #1, Hard Code
  #2. Config file
  #-------Cucumber it self provides multiple option through wich we can feed data from
  # feature file into Step Definition
  #3. Regular Expressions
  # put the data in double quotes [""]
  #4. Scenario OutLine
  # Provides you an alternative to data driven testing
  # Also supports parametrization
  #===================================PARAMETERIZATION================================
 # Executing the same test case with multiple data
