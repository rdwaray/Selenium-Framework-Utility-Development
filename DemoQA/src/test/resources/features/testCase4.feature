@TestCase4
Feature: Widgets
  Background:
    Given I am on the DEMOQA homepage
    Then I go to Widgets test page

  @Accordian
    Scenario: Accordian Interactions
    Given I go to Accordian test page
    Then I click on Accordian one
    And I extract Accordian one text
    Then I click on Accordian two
    And I extract Accordian two text
    Then I click on Accordian three
    And I extract Accordian three text

  @AutoComplete
  Scenario: Auto Complete Form Box
    Given I go to Auto Complete Test Page
    Then I fill multiple form  with "I"
    And I choose multiple color "White"
    Then I fill multiple form again with "D"
    And I choose the next multiple color "Red"

    Then I fill single form with "G"
    And I choose single color "Green"

  @DatePicker
  Scenario: Input date and time
    Given I am on Date Picker Test
    Then I input Date
    And I input date and time

  @Slider
  Scenario: Slider input data type
    Given I am on Slider test page
    Then I am changing the value of slider

  @ProgressBar
  Scenario: Progress bar interactions and getting that value
    Given I am on Progress Bar test Page
    Then I click start progress button
    And I click stop
    And I extract progress bar value

  @Tabs
  Scenario: Interaction Tabs
    Given I am on Tabs test page
    Then I click on What Tab
    And I click on Origin Tab
    And I click on Use Tab
    And I click on More Tab

  @MouseHover
  Scenario: Hovering mouse cursor
    Given I am on Tool Tips test page
    Then I hover mouse to element one
    And I hover mouse to element two
    And I hover mouse to element three
    And I hover mouse to element four

  @MouseHoverMenu
    Scenario: Hovering Mouse Through Menu
    Given I on on Menu test page
    Then I am hovering Main Item one
    When I am hovering Main Item two
    And I am Hovering Main Item three

  @SelectMenuDropDown
  Scenario: Drop down menu interaction
    Given I am on Select Menu test page






