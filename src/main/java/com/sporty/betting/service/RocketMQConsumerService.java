package com.sporty.betting.service;

import com.sporty.betting.model.Bet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * This is a MOCK class.
 * In a real-world application, this class would be a RocketMQ consumer that listens
 * to the 'bet-settlements' topic and processes bet settlement messages.
 */
@Slf4j
@Service
public class RocketMQConsumerService {

    public void settleBet(Bet bet) {
        // Simulate bet settlement logic
        log.info("Consumed from RocketMQ topic 'bet-settlements': {}", bet);
        log.info("Bet settled for user '{}', amount: Rs. {}", bet.getUserId(), bet.getBetAmount());
    }
}
