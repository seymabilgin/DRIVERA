@DB @DB_US04
Feature:US04 | Login History table validate column names and information
  Scenario:Login History table column names and information are validated
    Given  Login History table send query to get column names and information
    Then Login History table column names and information are verified