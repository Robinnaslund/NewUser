Feature:

  Scenario: I sign upp a new user
    Given I write an email address "444@mail.com"
    Given I write a username "Robin96"
    Given I write password "Golfare96!"
    When I click on Sign up


  Scenario: Writing a long username
    Given I write an email address "444@gmail.com"
    Given I write a username "Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96Robin96"
    Given I write password "Golfare96!"
    When I click on Sign up
    Then Error message is displayed "Enter a value less than 100 characters long"


  Scenario: Already an existing user
      Given I write an email address "444@gmail.com"
      Given I write a username "Robin96"
      Given I write password "Golfare96!"
      When I click on Sign up
      Then Error message is displayed "Another user with this username already exists. Maybe it's your evil twin. Spooky."
    
    Scenario: Signing a new user without email
      Given I write a username "Robin1296"
      Given I write password "Iamthebest123!"
      When I click on Sign up
      Then Error message is displayed "Please enter a value"






