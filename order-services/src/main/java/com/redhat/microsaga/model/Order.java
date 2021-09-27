package com.redhat.microsaga.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Order {


   private String id;

   private String customerId;

   private Double totalPrice;


   private List<ProductItem> productItems;

   private String paymentCardId;

   private String shippingAddressId;

   public Order(){}

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getCustomerId() {
      return customerId;
   }

   public void setCustomerId(String customerId) {
      this.customerId = customerId;
   }

   public Double getTotalPrice() {
      return totalPrice;
   }

   public void setTotalPrice(Double totalPrice) {
      this.totalPrice = totalPrice;
   }

   public List<ProductItem> getProductItems() {
      return productItems;
   }

   public void setProductItems(List<ProductItem> productItems) {
      this.productItems = productItems;
   }

   public String getPaymentCardId() {
      return paymentCardId;
   }

   public void setPaymentCardId(String paymentCardId) {
      this.paymentCardId = paymentCardId;
   }

   public String getShippingAddressId() {
      return shippingAddressId;
   }

   public void setShippingAddressId(String shippingAddressId) {
      this.shippingAddressId = shippingAddressId;
   }

   @Override
   public String toString() {
      return "Order{" +
            "id='" + id + '\'' +
            ", customerId='" + customerId + '\'' +
            ", totalPrice=" + totalPrice +
            ", productItems=" + productItems +
            ", paymentCardId='" + paymentCardId + '\'' +
            ", shippingAddressId='" + shippingAddressId + '\'' +
            '}';
   }
   public double generateDouble() {
      double leftLimit = 1D;
      double rightLimit = 10D;
      double generatedDouble = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
      return generatedDouble;
  }
   public Order generateOrder(){
      this.setId(UUID.randomUUID().toString());
      this.setCustomerId(UUID.randomUUID().toString());
      ProductItem pi = new ProductItem();
      Random random = new Random();
      pi.setId(random.nextLong());
      pi.setPrice(generateDouble()); 
      pi.setProductId(UUID.randomUUID().toString());
      pi.setQuantity(random.nextInt(32));
      List<ProductItem> productItems = new ArrayList<ProductItem>();
      productItems.add(pi);
      this.setProductItems(productItems);
      this.setPaymentCardId(UUID.randomUUID().toString());
      this.setShippingAddressId(UUID.randomUUID().toString());
      double total = 0;
      for(ProductItem p : productItems){
         total += (p.getPrice()*p.getQuantity()); 
      }
      this.setTotalPrice(total);
      return this;
   }
}
