Feature: Ebay search functionality
  Scenario: Search for imac 2020
    Given  user is on ebay homepage
    When user searches for iMac 2020
    Then user sees results about i mac only
    Then  there are more than 3 pages of result