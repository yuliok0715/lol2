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

  Scenario: delete one copy
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I set number of goods 2
    And I click minus to delete one copy
    Then Number of items is 1
    And Browser is closed

    Scenario: buy 50
      Given Browser "chrome" is opened
      And Website "https://rozetka.com.ua" is opened
      When I click on "Apple"
      And I set number of goods 50
      Then Number of items is 50
      And Browser is closed

  Scenario: bucket is stable
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I close bucket
    And I click on "bucket"
    Then Good "Apple" is in bucket
    And Browser is closed

