package com.sporty.betting.service;

import com.sporty.betting.model.Bet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * This is a MOCK class.
 * In a real-world application, this class would use RocketMQ client libraries
 * to publish messages to a RocketMQ topic named 'bet-settlements'.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RocketMQProducerService {

    private final RocketMQConsumerService rocketMQConsumerService;

    public void sendToRocketMQ(Bet bet) {
        // Simulate sending to RocketMQ
        log.info("Sent bet to RocketMQ topic 'bet-settlements': {}", bet);

        // Directly invoke the consumer to simulate processing
        rocketMQConsumerService.settleBet(bet);
    }
}
