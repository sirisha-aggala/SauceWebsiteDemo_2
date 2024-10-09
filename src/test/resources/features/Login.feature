Feature: Login Functionality
Background:
 Given user launches the url of the application

# passing parameters within the step
Scenario: To validate login functionality of the bahmni application
  #  Given user launches the url of the application
    When enters valid credentials as "standard_user" and "secret_sauce"
    And click on Login button
     Then usershould be able to land on home page of the application

   # @regression
   # passing parameters using examples in Scenario Outline
#Scenario Outline: To validate login functionality of the bahmni application
# #  Given user launches the url of the application
#   When enters valid credentials as "<username>" and "<password>"
#   And click on Login button
#   Then usershould be able to land on home page of the application
#   Examples:
#    | username | password|
#    | standard_user | secret_sauce|
#  # | locked_out_user | secret_sauce|
#    | error_user | secret_sauce |
#
#    #passing parameters using Data Table
#Scenario:To validate login functionality using Data table as lists
#   #   Given user launches the url of the application
#      When enters valid credentials as username and password as below
#        | standard_user | secret_sauce|
#         | locked_out_user | secret_sauce|
#      #    | error_user | secret_sauce |
#     # And click on Login button
#      Then usershould be able to land on home page of the application
#
#  #  Scenario:To validate login functionality using Data table as map
#  #    Given user launches the url of the application
#  #    When enters valid credentials as username and password
#  #       |username|password|
#  #       |locked_out_user|secret_sauce|
#  #        |error_user|secret_sauce|
#  #    And click on Login button
#  #    Then usershould be able to land on home page of the application
