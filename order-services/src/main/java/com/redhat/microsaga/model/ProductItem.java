package com.redhat.microsaga.model;

public class ProductItem {


   private Long id;

   private String productId;

   private Integer quantity;

   private Double price;

   public ProductItem(){}

   public ProductItem(Long id, String productId, Integer quantity, Double price){
      this.id = id;
      this.productId = productId;
      this.quantity = quantity;
      this.price = price;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getProductId() {
      return productId;
   }

   public void setProductId(String productId) {
      this.productId = productId;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   @Override
   public String toString() {
      return "ProductItem{" +
            "id=" + id +
            ", productId='" + productId + '\'' +
            ", quantity=" + quantity +
            ", price=" + price +
            '}';
   }
}
