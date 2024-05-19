Feature: Amazon Shopping

Feature: Adding a Monitor Item in Cart and verifying subtotal

  @scenario1
  Scenario: Adding a Monitor Item in Cart and verifying subtotal
    Given User is on the Amazon website
    When User searches for "Monitor"
    And User selects the 1st item in the List
    Then User fetch product price on product page
    And User adds the item to cart
    And User opens the Cart
    Then User fetch product price on cart page
    Then User fetch sub total price on cart page
    Then Verify that the price is identical to the product page
    And Verify that the subtotal is identical to the product page

  @scenario2
  Scenario: Adding a Laptop Item in Cart and verifying subtotal
    Given User is on the Amazon website
    When User searches for "Laptop"
    And User selects the 2st item in the List
    Then User fetch product price on product page
    And User adds the item to cart
    And User opens the Cart
    Then User fetch product price on cart page
    Then User fetch sub total price on cart page
    Then Verify that the price is identical to the product page
    And Verify that the subtotal is identical to the product page

  @scenario3
  Scenario: Adding a Headphones and Keyboard Item in Cart and verifying subtotal
    Given User is on the Amazon website
    Then User sets american address
    When User searches for "Headphones"
    And User selects the 1st item in the List
    Then User fetch product price on product page
    And User adds the item to cart
    And User opens the Cart
    Then User fetch product price on cart page
    Then User fetch sub total price on cart page
    Then Verify that the price is identical to the product page

    When User searches for "Keyboard"
    And User selects the 1st item in the List
    Then User fetch product price on product page
    And User adds the item to cart
    And User clicks "ESCAPE"
    And User opens the Cart
    Then User fetch product price on cart page
    Then User fetch sub total price on cart page
    Then Verify that the price is identical to the product page
    Then Verify that the subtotal is calculated correctly