@tag
Feature: Admin Login
  I want to use this template to check Admin Login with valid inputs
    
    
    Background: Common steps
    Given i open browser with url "http://orangehrm.qedgetech.com"
    Then i shold see login page
   

  @Adminlogin
  Scenario: Check Admin Login with valid inputs
    When i enter username as "Admin"
    And i enter password as "Qedge123!@#"
    And i click login
    Then i should see admin module
    When i click logout
    Then i shold see login page
    When i close browser
   
  @Invalidlogin
  Scenario Outline: Check Admin Login with invalid inputs
    When i enter username as "<username>"
    And i enter password as "<password>"
    And i click login
    Then i should see error message
    When i close browser
    
    Examples: 
      | username | password    |
      | Admin    | xyz         |
      | abc      | Qedge123!@# |
      | abc      | xyz         |
