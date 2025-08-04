# Sports Betting Settlement System (Kafka + Mocked RocketMQ)

This project simulates a backend service for handling sports event outcomes and settling bets using Kafka and a mocked RocketMQ setup.

---

## Problem Statement

Build a backend application that simulates sports betting event outcome handling and bet settlement using Kafka and RocketMQ.

Requirements:

1. An API endpoint to publish a sports event outcome to Kafka.
2. A Kafka consumer that listens to `event-outcomes` Kafka topic.
3. Matches the event outcome to bets stored in memory and identifies winning bets.
4. A RocketMQ producer that sends messages to `bet-settlements`.
5. A RocketMQ consumer that listens to `bet-settlements` and settles the bet.

Note: RocketMQ integration is mocked using regular Spring services.

---

## How to Run

### Prerequisites

- Java 17
- Maven
- Docker & Docker Compose

### IDE Setup

This project requires **Java 17**. Your IDE might default to a different JDK. To avoid compilation errors, please ensure your IDE's project settings are explicitly configured to use JDK 17.

* **For IntelliJ IDEA**:
   * Go to `File` > `Settings` > `Build, Execution, Deployment` > `Build Tools` > `Maven` > `Runner`.
   * In the `JRE` dropdown, select your installed **JDK 17**.

### Steps

1. Start Kafka:

   ```bash
   docker-compose up -d
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application from:

   ```
   com.sporty.betting.SportsBettingApp
   ```

This will start the application on port `8080`.

---

## API Endpoint

### POST `/api/event-outcomes`

Publishes a sports event outcome to Kafka topic `event-outcomes`.

#### Sample Request:

```json
{
  "eventId": "match-001",
  "eventName": "India vs Australia",
  "eventWinnerId": "India"
}
```
<img width="835" height="871" alt="image" src="https://github.com/user-attachments/assets/1748e6f7-7891-4a07-bf44-9a1f984fb65e" />

#### Expected Flow:

- Kafka producer sends the outcome to the topic `event-outcomes`.
- Kafka consumer receives the outcome and checks in-memory bets.
- For winning bets, a mock RocketMQ producer is called.
- The RocketMQ consumer (also mocked) settles the bet by logging.

#### Sample Console Output:

```
Received event outcome from Kafka: match-001
Bet matched (WON): Bet(betId=bet1, userId=user1, ...)
Sent bet to RocketMQ topic 'bet-settlements': bet1
Consumed from RocketMQ: bet1
Bet settled for user user1, amount: Rs. 100.0
```

---

## Notes

- No database is used. All bets are loaded into an in-memory repository at startup.
- RocketMQ components are mocked to avoid needing a real RocketMQ setup.
- Messages can be verified through logs during testing.

