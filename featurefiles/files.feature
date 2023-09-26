Feature: Checking the Facebook Login Page

  Scenario Outline: Checking login fields with invalid data
    Given Facebook URL is launched
    When User Enters the "<Username>" and "<password>"
    When click login button
    Then Take "<screenshot>"

    Examples: 
      | Username | password | screenshot |
      | ranji    | rrrra    | ran        |
      | ranj     | rrra     | ranj       |
      | rannji   | rra      | raan       |

  Scenario: Checking Forgot Password
    Given Facebook url loading
    When User Click Forgot Password
    When User Enter email and Click search
    Then Take ScreenShot Of Result
