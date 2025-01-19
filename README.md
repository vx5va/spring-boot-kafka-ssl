# spring-boot-kafka-ssl
Learning how to connect to Kafka with SSL in Spring Boot

# Kafka scripts
Act as a producer on a running Kafka container
`docker exec -it --tty broker kafka-console-producer --bootstrap-server localhost:9092 --topic "customer.visit"`

Act as a consumer on a running Kafka container
`docker exec -it --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic "customer.visit" --from-beginning`
