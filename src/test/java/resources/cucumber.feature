Feature: I_HATE_ROZETKA

  Scenario: buy one
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    Then The bucket is "opened"
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

  Scenario: open bucket
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "bucket"
    Then The bucket is "opened"
    And Bucket is empty
    And Browser is closed

  Scenario: close bucket
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "bucket"
    And I close bucket
    Then The bucket is "closed"
    And Browser is closed

  Scenario: delete by typing zero
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I set number of goods 0
    Then Bucket is empty
    And Browser is closed

  Scenario: delete one item
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I delete "Apple"
    Then Bucket is empty
    And Browser is closed

  Scenario: two different items
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I close bucket
    And I click on "Samsung"
    Then Good "Apple" is in bucket
    And Good "Samsung" is in bucket
    And Browser is closed

  Scenario: delete one of items
    Given Browser "chrome" is opened
    And Website "https://rozetka.com.ua" is opened
    When I click on "Apple"
    And I close bucket
    And I click on "Samsung"
    And I delete "Apple"
    Then Good "Samsung" is in bucket
    And Good "Apple" not in bucket
    And Browser is closed
