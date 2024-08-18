@DB @DB_US05
Feature:US05 | Social Login table validate column names and information
  Scenario:Social Login table column names and information are validated
    Given  Social Login table send query to get column names and information
    Then Social Login table column names and information are verified