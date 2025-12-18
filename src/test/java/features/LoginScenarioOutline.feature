@Regression
Feature: Login Scenario Outline

  Background:
    Given user launch the application

  @tag2
  Scenario Outline: login with Multiple Credentials
    When user logs in with "<userName>" and "<password>"
    Then user should verify Message "<message>"

    Examples:
      | userName | password | message             |
      | admin    | admin123 | Dashboard           |
      | user1    | pass123  | Invalid credentials |

  @smoke
  Scenario: login with Data Table
    When user logs in with credentials
      | userName | password |
      | admin    | admin123 |
    Then user should be redirected to the dashboard