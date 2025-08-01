package com.sporty.betting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventOutcome {
    private String eventId;
    private String eventName;
    private String eventWinnerId;
}