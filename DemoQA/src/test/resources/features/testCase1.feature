@TestCase1
Feature: Element
  Background:
    Given I am on the DEMOQA homepage
    Then I go to Element test page

  @TextBox
  Scenario: Input text boxt

    Then I click on Text Box test
    And I fill full name, email, Current Address, Permanent Address with fake data

    Then I click on submit form button

  @CheckBox
  Scenario: Click on check box
    Then I on Check Box test
    And I click on Home drag down button
    And I click on Desktop drag down button
    And I click on Documents drag down button
    And I click on Download drag down button
    When I click on all check boxes
    Then I should get the selected box name list

  @RadioButton
  Scenario: Click on radio button
    Given I on radio test
    Then I click on Yes button
    And I should see radio button message

    Then I click on Impresssive button
    And I should see radio button message

    When I click on No Button
    Then  The button cannot be pressed

   @WebTables
   Scenario: Web table navigation and adding some data
     Given I am on Web Tables test
     Then I should add data
     And I fill First Name
     And I fill Last Name
     And I fill email
     And I fill age
     And I fill salary
     And I fill departement
     When I click on submit registration form
     Then I should see the data form

     When I search "Cierra"
     Then I should see Cierra data

     Then I change form row to 100 to 5


     When I change Cierra first name to "Ray"
     Then I should see Cierra data that changed to "Ray"

    @Button
    Scenario: Left and right click input method
      Given I am on Buttons test
      When I click on Double Click Me button
      Then I should see input double click message
      And I click on Right Click Me button
      Then I should see input right click message
      And I click on Click Me button
      Then I should see input click message

    @Links
    Scenario: Interaction with links element dan windows tab
      Given I am on Links test
      When I click on Home link
      Then I should be in different windows tab
      And I go back to maintab
      Then I click on HomehrToG link
      Then I should be in different windows tab
      And I go back to maintab

      When I click on Created link
      Then I should see link respone code
      And I click on No Content
      Then I should see link respone code
      And I click on Moved link
      Then I should see link respone code
      And I click on Bad Request link
      Then I should see link respone code
      And I click on Unauthorized link
      Then I should see link respone code
      And I click on Forbidden link
      Then I should see link respone code
      And I click on Not Found link

    @ValidImageandLinks
    Scenario: Find the broken images and link
      Given I am on Broken link image and link
      When I check image validation
      Then I should see the validation image "url"

      And I check link validation
      Then I should see validation link "url"

   @DownloadandUpload
    Scenario: Download and upload file
     Given I am on Upload and Download test
     When I click on download button
     Then I download the file
     And I click on upload button
     Then I uploaded file

  @DynamicProperties
    Scenario: Find dynamic element properties
    Given I am on Dynamic Properties test
    When I wait 5 second until button interactable
    Then I the button should be interactable
    And I should see button color change
    And I should see new button appear