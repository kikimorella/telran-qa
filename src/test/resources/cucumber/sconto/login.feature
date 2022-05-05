Feature: Sconto Login Feature
    In order to see the user area
    I log in to the website

    Scenario: Successful Login
        Given I am on the Homepage
        When I click on the Login icon
        Then I see Login page

        When I insert valid user credentials
        And I click on Login button
        Then I should see icon text Mein Konto

        When I click on the Login icon
        Then I should be logged in

        When I click on logout Button
        Then I see Login page
        Then I should see icon text Anmelden

# Unsuccessful Login запускается только если вырезать Successful Login. Почему? Как исправить? Возможно, стоит добавить шаг -> выйти... //TODO

    Scenario: Unsuccessful Login
        Given I am on the Homepage
        When I click on the Login icon
        Then I see Login page

        When I insert invalid user credentials
        And I click on Login button
        Then I see Login page
        And I see validation message

