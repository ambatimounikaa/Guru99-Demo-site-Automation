#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Testing the new tours of Demo Guru99 page

  @tag1
  Scenario Outline: Verify the login page of new Tours
    Given user is on the homepage
    When I click on signin then username and password field should be displayed
    Then enter the "<username>" and "<password>"
    Then click on submit button and verify the sucessfull login
   
  @tag2
  Scenario: Verifying the flights page and Round trip functionality
  Given User is on the flights page
  Then make sure round trip type is selected
  And mention all the flight details
  Then specify the preferences and click on continue
  
  

    Examples: 
      | username  | password | 
      | mounika |     pass123 |

