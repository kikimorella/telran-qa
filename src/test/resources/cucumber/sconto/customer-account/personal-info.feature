Feature: Customer Account Personal Info page Tests

    Scenario Outline: Edit Customer Personal Info
        Given I am on Customer Account Page

        When I click on Ihre Kundendata
        Then I see Data page

        When I click on Ihre persönlichen Daten
        And I click on Edit button
        And I change customer name to <name>
        And I change customer lastname to <surname>
        And I click Save button
        Then I see customer name <name> <surname>

        When I return everything back
#        When I click on Ihre persönlichen Daten
#        And I click on Edit button
#        And I change customer name to Violeta
#        And I click Save button
#        Then I see customer name Violeta

        Examples:
           | name   |  surname |
           | Anna   | Last     |
           | karl   | first    |
           | 12345  | 12345    |
           | abcde  | abcde    |
#       Я же правильно понимаю, что таким образом мы не можем заполнять поля пробелами?
