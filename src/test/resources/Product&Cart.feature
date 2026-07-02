@smoke @product @cart 
Feature: Product Search and Cart Management

  Background:
    Given User clicks Products menu

  Scenario Outline: Search product, add to cart and remove from cart

    When User searches product "<product>"
    And User adds searched product to cart
    And User clicks View Cart
    Then Product "<product>" should be displayed in cart
    When User removes product from cart
    Then Cart should become empty

    Examples:
      | product            |
      | Blue Top           |

