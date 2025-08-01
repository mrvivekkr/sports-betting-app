package com.sporty.betting.service;

import com.sporty.betting.model.Bet;
import com.sporty.betting.model.EventOutcome;
import com.sporty.betting.repository.BetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventOutcomeHandlerService {

    private final BetRepository betRepository;
    private final RocketMQProducerService rocketMQProducer; // mocked implementation

    @KafkaListener(topics = "event-outcomes")
    public void handleEventOutcome(EventOutcome outcome) {
        log.info("Received event outcome from Kafka: {}", outcome);

        List<Bet> betsForEvent = betRepository.findByEventId(outcome.getEventId());
        for (Bet bet : betsForEvent) {
            if (bet.getEventWinnerId().equalsIgnoreCase(outcome.getEventWinnerId())) {
                log.info("Bet matched (WON): {}", bet);
                rocketMQProducer.sendToRocketMQ(bet);
            } else {
                log.info("Bet did not match (LOST): {}", bet);
            }
        }
    }
}