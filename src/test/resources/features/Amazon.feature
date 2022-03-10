Feature: Amazon search functionalities
  Scenario:Positive scnario for amazon search
    When I navigate to amazon.com
    And I search for iphone 13 case
    Then I should get more than 20 results
    And I validate the search result number