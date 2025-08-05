@TestCase3
Feature: Alert, Frame, and Windows
  Background:
    Given I am on the DEMOQA homepage
    Then I go to Alert, Frame, and Windows test page

   @Alerts
   Scenario: Interactions with browser alerts
     Given I am on Alert test page
     Then I click on first alert and click OK
     And I click on second alert, wait for five seconds then click OK
     And I click on confirm alert
     And I click prompt box alert and fill "Ray"

   @Iframe
   Scenario: Switch between frames in HTML page
     Given I am on Frames test page
     Then I switch to iframe one
     And I switch to iframe two
     Then I go back to parent frame

  @Nestedframe
  Scenario: Switch between nested frames in HTML page
    Given I am on Nested Frames test page
    Then I switch to nested frame one
    And I switch to nested frame two
    Then I go back to nested parent frame

  @ModalDialogs
  Scenario: Interactions with small and large Modal
    Given I am on Modal Dialogs test page
    Then I click on Small Modal Button
    And I extract Small Modal text
    And Close Small Modal prompt
    Then I click on Large Modal Button
    And I extract Large Modal text
    And Close Large Modal prompt

