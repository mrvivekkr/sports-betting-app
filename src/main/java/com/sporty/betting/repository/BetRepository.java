package com.sporty.betting.repository;

import com.sporty.betting.model.Bet;

import java.util.List;

public interface BetRepository {
    void save(Bet bet);
    List<Bet> findByEventId(String eventId);
}