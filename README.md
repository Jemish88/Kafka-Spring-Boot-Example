Kafka-Spring-Boot-Example : A Learning Roadmap and Project
============================================================



# Spring Boot Application with Kafka and ZooKeeper Using Docker Compose

This guide will help you set up and run a Spring Boot application with Kafka and ZooKeeper using Docker Compose.


## Prerequisites

- **Docker**: Ensure that Docker is installed and running on your machine.
- **Docker Compose**: Docker Compose is required to manage multiple containers, including your Spring Boot application, Kafka, and ZooKeeper.
- **Java**: Ensure Java is installed (version 8 or higher).
  ```bash
  java -version

Introduction
---------------
This is a learning roadmap and task breakdown for building a Kafka project using Spring Boot.



Topics
--------

**1. Kafka Basics**

Description: Learn the basics of Kafka, its architecture and how it works (producers, consumers, brokers, topics, partitions).

Task:
* Install Kafka locally using Docker or manual installation.
* Learn basic Kafka commands (create topics, produce and consume messages).
* Add Spring Kafka and Apache Kafka dependencies in pom.xml or build.gradle.
* Configure application.yml or application.properties for Kafka (broker address, consumer group, etc.).

**2. Produce to Kafka**

Description: Learn how to produce messages to Kafka topics using KafkaTemplate in Spring Boot.

Task:
* Create a simple Spring Boot producer that produces to a Kafka topic.
* Build a REST API in Spring Boot that accepts user input and produces to Kafka.
* Handle errors for failed message delivery.

**3. Consume from Kafka**

Description: Learn how to consume messages from Kafka topics using @KafkaListener.

Task:
* Create a consumer service in Spring Boot using @KafkaListener to listen to a Kafka topic.
* Log and process consumed messages (store in database or do some action).
* Handle consumer errors (retry, dead-letter topics).

**4. Topic Management**

Description: Learn how to manage Kafka topics, including creating partitions and replication factor.

Task:
* Programmatically create Kafka topic in Spring Boot (if not already present).
* Configure partitioning for a topic.
* Implement a way to list, create and delete topics using Spring Kafka.

**5. Data Serialization and Deserialization**

Description: Learn how to serialize and deserialize messages (e.g., JSON, Avro, Protobuf) in Kafka using Spring Boot.

Task:
* Implement JSON serialization and deserialization using custom serializers.
* Explore and configure Avro or Protobuf serialization with Kafka.

**6. Kafka Consumer Groups and Offset Management**

Description: Learn about Kafka consumer groups, partition rebalancing and offset management.

Task:
* Create multiple consumers in the same group and see how messages are distributed.
* Manually commit offsets and learn how to handle rebalances.
* Explore auto vs manual offset commit.

**7. Kafka Error Handling and Retries**

Description: Learn how to handle errors, retries and implement dead-letter topics for failed messages.

Task:
* Configure Kafka's retry mechanism.
* Implement dead-letter queues to handle messages that exceed retry attempts.
* Use error handlers like SeekToCurrentErrorHandler for custom error handling.

**8. Kafka Transactions**

Description: Learn how Kafka handles transactions to ensure atomicity in message processing.

Task:
* Create transactional Kafka producers to ensure all-or-nothing message delivery.
* Create transactional consumers to process messages in batches.

**9. Kafka Streams**

Description: Learn Kafka Streams API to build streaming applications that process Kafka messages in real-time.

Task:
* Create a Kafka Streams application in Spring Boot that reads from one topic and writes to another.
* Implement basic operations (map, filter, group, aggregate)

**10. Monitoring and Metrics**

Description: How to monitor Kafka and Spring Boot applications using JMX, Prometheus or other tools.

Task:
* Enable Kafka metrics and export via JMX.
* Integrate Prometheus and Grafana to visualize Kafka metrics (e.g. message rates, lag, consumer health)

**11. Kafka Security**

Description: Kafka security configurations - SSL encryption, authentication, ACLs

Task:
* SSL/TLS between Kafka brokers and clients
* SASL/SSL for authentication
* ACLs to restrict access to topics

**12. Kafka in Microservices**

Description: How Kafka fits into a microservices architecture to enable service communication.

Task:
* Create a microservice that produces events and another microservice that consumes those events via Kafka.
* Event driven order processing system

**13. Testing Kafka Applications**

Description: How to test Kafka producers, consumers and stream processing applications in Spring Boot

Task:
* Write unit tests for Kafka producers using @EmbeddedKafka or a mock Kafka server.
* Write integration tests for consumers and Kafka Streams using in-memory Kafka clusters.

**14. Kafka and Cloud**

Description: How to deploy Kafka and Spring Boot applications on cloud (AWS, GCP, Kubernetes)

Task:
* Managed Kafka service (e.g. AWS MSK or Confluent Cloud)
* Deploy Spring Boot Kafka application on Kubernetes, using Helm or similar

Project-Based Learning Approach
-------------------------------

Project Name: KafkaConnect

**Phase 1: Basic Producer-Consumer Setup**

* Kafka and Spring Boot integration
* Create producer and consumer services.
* REST API to send messages to Kafka.

**Phase 2: Serialization, Partitions, Error Handling**

* JSON and custom serialization
* Errors, retries, dead-letter topics
* Partitioning for high-throughput

**Phase 3: Kafka Streams**

* Kafka Streams applications for real-time data processing
* Filtering and aggregation

**Phase 4: Transactions and Monitoring**

* Kafka transactions
* Prometheus and Grafana for metrics

**Phase 5: Security and Cloud**

* Secure Kafka with SSL/TLS.
* Deploy the project on cloud platforms (AWS or GCP).



# Kafka with ZooKeeper
**Run the following commands in order to start all services in the correct order:**


# Start the ZooKeeper service
    $ bin/zookeeper-server-start.sh config/zookeeper.properties
# Start the Kafka broker service
Open another terminal session and run:

    $ bin/kafka-server-start.sh config/server.properties

Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

**1. List all topics:**
To see all the Kafka topics available, use:

    ./kafka-topics.sh --list --bootstrap-server localhost:9092

**2. Describe a topic:**
To check the details of a specific topic (including partition details and offsets):

    ./kafka-topics.sh --describe --topic <topic_name> --bootstrap-server localhost:9092

**3. List all consumer groups:**
To list all consumer groups (group IDs):

    ```./kafka-consumer-groups.sh --list --bootstrap-server localhost:9092

**4. Describe a consumer group:**
To get details about a specific consumer group (including lag, committed offsets, and partitions):

    ./kafka-consumer-groups.sh --describe --group <group_id> --bootstrap-server localhost:9092

**5. Consume messages from a topic:**
To read the messages from the beginning of a specific topic:

    ./kafka-console-consumer.sh --topic <topic_name> --from-beginning --bootstrap-server localhost:9


**6. Produce messages to a topic:**
To send messages to a topic:

    ./kafka-console-producer.sh --topic <topic_name> --bootstrap-server localhost:9092

**7. Check topic offsets:**
To get the latest offsets for a specific topic (helpful for monitoring lag):

    /kafka-run-class.sh kafka.tools.GetOffsetShell --topic <topic_name> --time -1 --bootstrap-server localhost:9092

**Command to read all messages from a Kafka topic:**

    kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <topic_name> --from-beginning


