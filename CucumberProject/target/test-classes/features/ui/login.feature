Feature: Login Feature

  @SmokeTest
  Scenario: Login successfully with the valid username & password
    Given the user is on the login screen
    When the user enters the username "standard_user"
    And the user enters the password "secret_sauce"
    And the user clicks on the login button
    Then the user should see the homepage
    Then the user should see the logout button

  @NegativeTest
  Scenario: Login fails due to incorrect password
    Given the user is on the login screen
    When the user enters the username "standard_user"
    And the user enters the password "123456"
    And the user clicks on the login button
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"

  @NegativeTest
  Scenario: Login fails due to incorrect username
    Given the user is on the login screen
    When the user enters the username "standard_user1"
    And the user enters the password "secret_sauce"
    And the user clicks on the login button
    Then the user should see an error message "Epic sadface: Username and password do not match any user in this service"

  @NegativeTest
  Scenario: Login fails due to empty username
    Given the user is on the login screen
    When the user enters the username ""
    And the user enters the password "secret_sauce"
    And the user clicks on the login button
    Then the user should see an error message "Epic sadface: Username is required"

  @NegativeTest
  Scenario: Login fails due to empty password
    Given the user is on the login screen
    When the user enters the username "standard_user"
    And the user enters the password ""
    And the user clicks on the login button
    Then the user should see an error message "Epic sadface: Password is required"

  @NegativeTest
  Scenario: Login fails due to the account is locked
    Given the user is on the login screen
    When the user enters the username "locked_out_user"
    And the user enters the password "secret_sauce"
    And the user clicks on the login button
    Then the user should see an error message "Epic sadface: Sorry, this user has been locked out."
