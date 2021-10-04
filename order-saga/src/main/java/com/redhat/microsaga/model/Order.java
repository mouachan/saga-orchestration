/*
 * Order API
 * Order API for https://github.com/redhat-france-sa/microservices-saga-blueprint
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.redhat.microsaga.model;

import java.util.Objects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Order
 */
public class Order {

  private String id;


  private String status;


  private String customerId;

 
  private List<ProductItem> productItems = new ArrayList<ProductItem>();


  private Double totalPrice;

  


  private String currency;


  private String paymentCardId;


  private String shippingAddressId;

  Order() {}

  public Order(String id) {
    
    this.id = id;
  }

   /**
   * Unique identifier of order
   * @return id
  **/

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


   /**
   * Status of Order
   * @return status
   **/

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


   /**
   * Get customerId
   * @return customerId
  **/

  public String getCustomerId() {
    return customerId;
  }


  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public void productItems(List<ProductItem> productItems) {
    this.productItems = productItems;
  }

  public void addProductItemsItem(ProductItem productItemsItem) {
    this.productItems.add(productItemsItem);
  }

   /**
   * Get productItems
   * @return productItems
  **/

  public List<ProductItem> getProductItems() {
    return productItems;
  }


  public void setProductItems(List<ProductItem> productItems) {
    this.productItems = productItems;
  }


   /**
   * Get totalPrice
   * @return totalPrice
   **/


  public Double getTotalPrice() {
    return totalPrice;
  }


  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

   /**
   * Get currency
   * @return currency
  **/

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    this.currency = currency;
  }



   /**
   * Get paymentCardId
   * @return paymentCardId
   **/

  public String getPaymentCardId() {
    return paymentCardId;
  }


  public void setPaymentCardId(String paymentCardId) {
    this.paymentCardId = paymentCardId;
  }



   /**
   * Get shippingAddressId
   * @return shippingAddressId
   **/

  public String getShippingAddressId() {
    return shippingAddressId;
  }


  public void setShippingAddressId(String shippingAddressId) {
    this.shippingAddressId = shippingAddressId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.status, order.status) &&
        Objects.equals(this.customerId, order.customerId) &&
        Objects.equals(this.productItems, order.productItems) &&
        Objects.equals(this.totalPrice, order.totalPrice) &&
        Objects.equals(this.currency, order.currency) &&
        Objects.equals(this.paymentCardId, order.paymentCardId) &&
        Objects.equals(this.shippingAddressId, order.shippingAddressId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, customerId, productItems, totalPrice, currency, paymentCardId, shippingAddressId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    productItems: ").append(toIndentedString(productItems)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    paymentCardId: ").append(toIndentedString(paymentCardId)).append("\n");
    sb.append("    shippingAddressId: ").append(toIndentedString(shippingAddressId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

