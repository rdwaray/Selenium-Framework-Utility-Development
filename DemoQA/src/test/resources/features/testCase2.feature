@TestCase2
Feature: Practice Form
  Background:
    Given I am on the DEMOQA homepage
    Then I go to Practice Form test page

  @Form
  Scenario: Input Form
    Given I fill first name with fake data
    And  I fill last name with fake data
    And I choose gender
    And I fill mobile number with fake data
    And I fill date of birth with fake data
    And I fill subject with "English"
    And I choose hobbies
    And I uploaded picture
    And I fiil address with fake data
    And I choose state "NCR" and "Delhi"
    Then I click on submit practice form
