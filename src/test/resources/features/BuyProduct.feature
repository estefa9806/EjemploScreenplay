#Author: ivethzapata19@gmail.com
Feature:Add an item to the shopping cart

  @BuyProduct
Scenario: Add an item to the shopping cart
     Given that Mariana is logged in
    |user|pass|
    |  usuario  |  Mariana123 |
    Then successful login is validated with usuario
    When and add a tablet to the shopping cart
    |menu|product|
    |TABLETS|HP Elite x2 1011 G1 Tablet|

