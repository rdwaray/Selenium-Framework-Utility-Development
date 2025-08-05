@TestCase6
Feature: Interaction
  Background:
    Given I am on the DEMOQA homepage
    Then I go to Interaction test page

  @Sortable
  Scenario: Sorting grid and list
    Given I go to Sortable test page
    Then I change the order of list
    When I go to Grid test
    Then I change the order of grid

  @Selectable
  Scenario: Select element on grid and list
    Given I go to Selectable test page
    Then I click the order of list
    When I go to Grid click test
    Then I click the order of grid

  @Resize
  Scenario: Resizing element
    Given I go to resize test page
    Then I resize element one
    And I resize element two

  @Droppable
  Scenario: Drop Element A to Element B
    Given I am on droppable test Page
    And I do Simple drop
    Then I do Accept drop
    And I do Prevent drop
    Then I do Revert drop

  @Draggable
  Scenario: Drag an element
    Given I am on Dragabble test page
    Then I drag simple element
    And I drag axes retristed element
    And I drag container retristed element
    And I drag cursor style element