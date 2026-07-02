@smoke @signup
Feature: User Registration

  @highpriority
  Scenario Outline: Register new user

    Given User navigates to the SignUp page
    When User enters signup name "<Name>"
    And User enters signup email prefix "<EmailPrefix>"
    And User completes registration with following details
      | Password  | <Password>  |
      | Title     | <Title>     |
      | Day       | <Day>       |
      | Month     | <Month>     |
      | Year      | <Year>      |
      | FirstName | <FirstName> |
      | LastName  | <LastName>  |
      | Company   | <Company>   |
      | Address   | <Address>   |
      | Country   | <Country>   |
      | State     | <State>     |
      | City      | <City>      |
      | ZipCode   | <ZipCode>   |
      | Mobile    | <Mobile>    |
    And User clicks Create Account button
    Then User account should be created successfully
    When User clicks Continue button
    Then User should be logged in successfully "<Name>"
    When User deletes the account
    Then Account should be deleted successfully

    Examples:
      | Name  | EmailPrefix | Password | Title | Day | Month | Year | FirstName | LastName | Company | Address | Country | State | City | ZipCode | Mobile |
      | Dishi | dishi | Admin123 | Mr | 27 | May | 1989 | Dishi | Gogia | OpenAI | Sector 45 | India | Haryana | Gurugram | 122003 | 9876543210 |
    