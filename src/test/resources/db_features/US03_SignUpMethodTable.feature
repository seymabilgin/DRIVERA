@DB @DB_US03
  Feature:US03 | SignUp table validate column names and information
    Scenario: Signup column names and information are validated
      Given  Signup send query to get column names and information
      Then Signup column names and information are verified