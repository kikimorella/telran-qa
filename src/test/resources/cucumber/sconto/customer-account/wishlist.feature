Feature: Customer Account Wishlist page Tests

#    Scenario Outline: Customer Account Wishlist displays list of items
    Scenario: Customer Account Wishlist displays list of items
        Given I am on Customer Account Page
        When I click on Ihre Wunschliste
        Then I see empty Wishlist

#        When I click on <menu> menu
#        Then I see <menu> page
         When I click on Sofas menu
         Then I see Sofas page

#        When I add <itemAmount> item to Wishlist
#        Then I see Wishlist icon is activated for <itemAmount> item
        When I add 1 item to Wishlist
        Then I see Wishlist icon is activated for 1 item
        And I see added item in Merkliste

        When I click on the Login icon
        Then I should be logged in

        When I click on Ihre Wunschliste
        Then I see added item

#        When I remove <itemAmount> item
        When I remove 1 item
        Then I see empty Wishlist

#        Examples: Credentials
#            | menu   | itemAmount |
#            | Betten | 1          |
#            | Sofas  | 3          |

#    Scenario: Customer Account Wishlist displays list of items
#        Given I am logged in
#        And I am on the Homepage
#
#        When I click on Sofa
#        Then I see Sofas page
#
#        When I click on Wishlist icon of the product
#        Then I see Wishlist icon is activated
#        And I see added item in Merkliste

#    Scenario: Search for the item on CA Wishlist
#        Given I am logged in as user with 5 wishlist items
#        And I see Home page
#
#        When I click on the Login icon
#        And I see Customer Account page
#
#        When I click on Ihre Wunschliste
#        Then I see 5 items on my Wishlist
#
#        When I search for item on the Wishlist
#        Then I see 1 item on wishlist
#        And I see item name corresponds to search name
#
  # это уже относится к тестированию Wixhlist, а не Customer Account Wishlist

#    Scenario: Delete item from Wishlist
#        Given I am logged in and Wishlist is not empty
#        And I see Customer Account page
#
#        When I click on Ihre Wunschliste
#        Then I see Wunschliste page with 3 items
#
#        When I click on cross on Sofa item
#        Then I see less items in Wishlist



#        Пример использования таблицы в сценарии

#        When I insert user name <username>
#        And I inser Password <password>
#        And I click on Login button
#        And I see error message
    """
        <text>
        """

#        Examples:
#        | username       | password | text
#        | test@test.test | 1        | Password is invalid
#        | 1              | pass     | Username is invalid


