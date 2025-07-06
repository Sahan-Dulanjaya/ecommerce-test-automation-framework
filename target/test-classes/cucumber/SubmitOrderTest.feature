Feature: Purchase the order from E-commerce website 
  As a user
  I want to purchase products from the application
  So that I can receive my order

  Background:
    Given I am on the home page

  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <username> and password <password>
    When I add a product <productName> to the cart
    And I proceed to checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples:
        | username | password | productName |
        | rahulshettyacademy@outlook.com  | RahulShetty#3  | ZARA COAT 3  |

 
