@first
Feature: Naukri Application  - Resume Updation

  Scenario Outline: Naukri Application Resume Updation
    Given user navigate to Naukri Application
    And enter the user credentials "<username>" and "<password>"
    When user navigate to my profile
    And Click on "update" in resume
    And user click on resume that has to be uploaded
    Then Resume should be uploaded successfully
    And user should see profile updated as "Today"

    Examples: 
      | username                | password  |
      | shriganesh593@gmail.com | shri@5393 |

  @second
  Scenario Outline: Naukri Application Resume Download
    Given user navigate to Naukri Application
    And enter the user credentials "<username>" and "<password>"
    When user navigate to my profile
    And Download the resume
    Then Verify if the resume is downloaded sucessfully
    And Verify if the downloaded resume contains "<email>" and "<mobilenumber>"
    Examples: 
      | username                | password  | email                   | mobilenumber |
      | shriganesh593@gmail.com | shri@5393 | Shriganesh593@gmail.com |   9698224433 |


#Scenario: Update Resume
    #When user navigate to my profile
    #And Click on "update" in resume
    #And user click on resume that has to be uploaded
    #Then Resume should be uploaded successfully
    #And user should see profile updated as "Today"
