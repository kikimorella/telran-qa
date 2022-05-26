Feature: Customer Account Personal Info page Tests

    Scenario Outline: Edit Customer Personal Info
        Given I am on Customer Account Page

        When I click on Ihre Kundendata
        Then I see Ihre Kundendaten page

        When I expand on Ihre persönlichen Daten
        When I click on Edit button
        Then I see Ihre persönlichen Daten edit form

        When I change customer name to <name>
        When I change customer lastname to <surname>
        When I click Save button
        Then I see customer name <name> <surname>

        When I return everything back
#        When I click on Ihre persönlichen Daten
#        Then I click on Edit button
#        Then I change customer name to Violeta
#        Then I click Save button
#        Then I see customer name Violeta
#        Then I logout?

        Examples:
           | name   |  surname |
           | Anna   | Last     |
           | karl   | first    |
           | 12345  | 12345    |
           | abcde  | abcde    |
#       Я же правильно понимаю, что таким образом мы не можем заполнять поля пробелами?
