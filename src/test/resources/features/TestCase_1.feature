Feature: Demo Project

  Scenario Outline: Test case 1: Positive LogIn test
    Given Open page
    Then Type "<username>" into Username field
    Then Type "<password>" into Password field
    Then Push Submit button
    Then Wait for 1 seconds
    Then Verify new page URL contains "https://practicetestautomation.com/logged-in-successfully/"
    Then Verify new page contains expected text ('Congratulations' or 'successfully logged in')
    Then Verify button Log out is displayed on the new page
    Then Close the browser

    Examples:
      | username | password    |
      | student  | Password123 |