package com.sporty.betting.config;
import com.sporty.betting.model.Bet;
import com.sporty.betting.repository.BetRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {

    private final BetRepository betRepository;

    @PostConstruct
    public void loadBets() {
        // match-001: India vs Australia
        betRepository.save(new Bet("bet1", "user1", "match-001", "winner", "India", 100));
        betRepository.save(new Bet("bet2", "user2", "match-001", "winner", "Australia", 150));
        betRepository.save(new Bet("bet3", "user3", "match-001", "winner", "India", 200));
        betRepository.save(new Bet("bet4", "user4", "match-001", "winner", "Draw", 75));

        // match-002: Argentina vs France
        betRepository.save(new Bet("bet5", "user5", "match-002", "winner", "Argentina", 300));
        betRepository.save(new Bet("bet6", "user6", "match-002", "winner", "France", 250));

        // match-003: England vs Germany
        betRepository.save(new Bet("bet7", "user7", "match-003", "winner", "England", 120));
        betRepository.save(new Bet("bet8", "user8", "match-003", "winner", "Germany", 90));

        log.info("📦 Sample bets loaded into in-memory repository.");
    }
}
