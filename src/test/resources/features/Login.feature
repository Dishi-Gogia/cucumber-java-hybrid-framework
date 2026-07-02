@smoke
Feature: Authentication
@positive
@regression @highPriority
Scenario Outline: Verify Login with Valid Credentials

Given User navigates to the Login page
When User enters username "<username>"
And User enters password "<password>"
And User clicks Login button
Then User should be logged in successfully "<loggedInUser>"

Examples:
| username         | password  | loggedInUser |
| dishi@gmail.com  | Password1 | Dishi Gogia  |


@negative
Scenario Outline: Verify Login with Invalid Credentials

Given User navigates to the Login page
When User enters username "<username>"
And User enters password "<password>"
And User clicks Login button
Then User should not be logged in successfully

Examples:  
| username         | password |
| dishi6@gmail.com | piu1     |




