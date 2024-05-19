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