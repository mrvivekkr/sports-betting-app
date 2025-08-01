package com.sporty.betting.service;

import com.sporty.betting.constants.KafkaTopics;
import com.sporty.betting.model.EventOutcome;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, EventOutcome> kafkaTemplate;

    public void sendEventOutcome(EventOutcome outcome) {
        kafkaTemplate.send(KafkaTopics.EVENT_OUTCOMES,outcome.getEventId(),outcome);
        log.info("Published event outcome to Kafka: {}", outcome);
    }
}
