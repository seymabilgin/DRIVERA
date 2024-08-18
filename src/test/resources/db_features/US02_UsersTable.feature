@DB @DB_US02
Feature: US02 |  Users validate column names and information
  Scenario: Users column names and information are validated
    Given  Users send query to get column names and information
    Then Users column names and information are verified