@DB @DB_US01
Feature: US01 | Validate Table Names
  Scenario:Table names are validated
    Given A query is sent to get the registered table names
    Then  Validate registered table names
