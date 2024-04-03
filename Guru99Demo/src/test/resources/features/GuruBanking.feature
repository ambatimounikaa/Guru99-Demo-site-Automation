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
Feature: For testing the banking project of Guru99 website

  @tag1
  Scenario Outline: To Test the login page of Guru99 banking
    Given user is on the login page of application
    And make sure the login & reset button is displayed
    When user enters the "<userId>" and "<password>"
    And click on the login button
    Then Gtpl bank page with welcome message should be displayed
 

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step

    Examples: 
      | userId  | password |
      | mngr564027 |     Unesagy |
