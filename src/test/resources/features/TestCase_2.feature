Feature: Demo Project

  Scenario Outline: Test case 2: Negative username test
    Given Open page
    Then Type "<username>" into Username field
    Then Type "<password>" into Password field
    Then Push Submit button
    Then Verify error message is displayed
    Then Verify error message text is Your username is invalid!
    Then Close the browser


    Examples:
      | username      | password    |
      | incorrectUser | Password123 |