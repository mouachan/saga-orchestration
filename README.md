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
# deployment on openshift
## create kafka cluster
## create infinispan cluster
## create Kogito ininispan infra
```shell
kogito install infra saga-infinispan-infra --kind Infinispan --apiVersion infinispan.org/v1 --resource-name saga-infinispan 
```
## create Kogito Kafka infra
```shell
kogito install infra saga-kafka-infra --kind Kafka --apiVersion kafka.strimzi.io/v1beta2 --resource-name saga-cluster
```   
## create configmap order-saga properties
```
oc create configmap order-saga-cm --from-file=./order-saga/src/main/resources/application.properties --dry-run=client -o yaml | oc apply -f -
```
 