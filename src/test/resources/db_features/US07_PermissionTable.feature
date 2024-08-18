@DB @DB_US07
Feature:US07 | Permission table validate column names and information
  Scenario:Permission table column names and information are validated
    Given  Permission table send query to get column names and information
    Then Permission table column names and information are verified