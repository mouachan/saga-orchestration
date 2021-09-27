# saga-orchestration

## start strimzi-all-in-one (kafka)
```docker
 docker compose up
```
## run order services
```mvn
 mvn clean compile quarkus:dev
```
## package order-saga  
```mvn
 mvn clean package
```
## run order-saga orchestrator
```java
 java -jar target/quarkus-app/quarkus-run.jar 
```
call the /order endpoint (POST) through the swagger http://localhost:8086/q/swagger-ui 

use the body :
```json
{
    "id":"12345",
    "status":"CREATED",
    "customerId":"12345",
    "productItems":[
        {
            "productId":"123",
            "quantity":1,
            "price":10.0
        }
    ],
    "totalPrice":10,
    "currency":"EUR",
    "paymentCardId":"1234",
    "shippingAddressId":"1234"
}
```
Or using curl 
```json
curl -X 'POST' \
  'http://localhost:8086/order' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d ' {
      "id": "12345","status": "CREATED","customerId": "12345","productItems":[{"productId":"123", "quantity":1, "price":10.0}],"totalPrice": 10,"currency": "EUR","paymentCardId": "1234","shippingAddressId": "1234"
   }'
```

 