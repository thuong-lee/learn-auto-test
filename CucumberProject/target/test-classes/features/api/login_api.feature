Feature: Login API Test

  @SmokeTest
  Scenario: Successful login
    Given input username and password
    When send a POST request to login api
    Then the response status is 200
    And the response contains token

  @NegativeTest
  Scenario: Failed login by incorrect username
    Given input incorrect username and correct password
    When send a POST request to login api
    Then the response status is 400
    And the response contains error "User name not found"

  @NegativeTest
  Scenario: Failed login by incorrect password
    Given input correct username and incorrect password
    When send a POST request to login api
    Then the response status is 400
    And the response contains error "Password is incorrect"

  @NegativeTest
  Scenario: Failed login by empty username
    Given input empty username and correct password
    When send a POST request to login api
    Then the response status is 422
    And the response contains message "The username field is required."

  @NegativeTest
  Scenario: Failed login by empty password
    Given input correct username and empty password
    When send a POST request to login api
    Then the response status is 422
    And the response contains message "The password field is required."

  @NegativeTest
  Scenario: Failed login by empty username and password
    Given input empty username and password
    When send a POST request to login api
    Then the response status is 422
    And the response contains message "The username field is required. (and 1 more error)"
