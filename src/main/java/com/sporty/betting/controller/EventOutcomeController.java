package com.sporty.betting.controller;

import com.sporty.betting.model.EventOutcome;
import com.sporty.betting.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event-outcomes")
@RequiredArgsConstructor
public class EventOutcomeController {

    private final KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<String> publishEventOutcome(@RequestBody EventOutcome outcome) {
        kafkaProducerService.sendEventOutcome(outcome);
        return ResponseEntity.ok("Event outcome published to Kafka successfully.");
    }
}
