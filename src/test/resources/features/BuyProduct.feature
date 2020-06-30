#Author:estefa9806@gmail.com
Feature:Add an item to the shopping cart

  @BuyProduct
Scenario: Add an item to the shopping cart
     Given that Mariana is logged in
    |user|pass|
    |  mariana  |  Mariana123 |
    Then successful login is validated with mariana
    When and add a tablet to the shopping cart
    |menu|product|
    |TABLETS|HP Elite x2 1011 G1 Tablet|

