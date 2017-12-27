Feature: Cucumber

Scenario: buy one
Given Browser "chrome" is opened
And Website "https://rozetka.com.ua" is opened
When I click on "Apple"
Then The bucket is opened
And Good "Apple" is in bucket
  And Browser is closed

  Scenario: buy оne more
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I click plus to add one more
    Then Number of items is 2
    And Browser is closed
