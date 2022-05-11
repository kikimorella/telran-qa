Feature: Customer Account Personal Info page Tests

    Scenario: Edit Customer Personal Info
        Given I am on Customer Account Page

        When I click on Ihre Kundendata
        Then I see Data page

        When I click on Ihre persönlichen Daten
        And I click on Edit button
        And I change customer name to Anna
        And I click Save button
        Then I see customer name Anna

        When I click on Ihre persönlichen Daten
        And I click on Edit button
        And I change customer name to Violeta
        And I click Save button
        Then I see customer name Violeta
