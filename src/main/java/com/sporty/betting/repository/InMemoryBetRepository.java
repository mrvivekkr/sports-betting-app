package com.sporty.betting.repository;

import com.sporty.betting.model.Bet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryBetRepository implements BetRepository{

    private final Map<String, Bet> betStore = new ConcurrentHashMap<>();

    @Override
    public void save(Bet bet) {
        betStore.put(bet.getBetId(), bet);
    }

    @Override
    public List<Bet> findByEventId(String eventId) {
        return betStore.values().stream()
                .filter(bet -> bet.getEventId().equals(eventId))
                .collect(Collectors.toList());
    }
}
