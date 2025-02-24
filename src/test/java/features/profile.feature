@first
Feature: Naukri Application  - Resume Updation
Background: 

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

#Scenario: Edit Carrer Profile
 # When user naviagte to my profile
 # And Click on carrer profile
 # And user click on "preffered location", select/deslect a "location"
 # And click on save button
 # Then user should see profile updated as "Today"

#Scenario: Update Resume
    #When user navigate to my profile
    #And Click on "update" in resume
    #And user click on resume that has to be uploaded
    #Then Resume should be uploaded successfully
    #And user should see profile updated as "Today"
