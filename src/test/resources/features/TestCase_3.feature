Feature: Demo Project

  Scenario Outline: Test case 3: Negative password test
    Given Open page
    Then Type "<username>" into Username field
    Then Type "<password>" into Password field
    Then Push Submit button
    Then Verify error message is displayed
    Then Verify error message text is Your password is invalid!

    Examples:
      | username | password          |
      | student  | incorrectPassword |