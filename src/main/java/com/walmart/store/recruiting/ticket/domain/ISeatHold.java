package com.walmart.store.recruiting.ticket.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ISeatHold {

	Optional<LocalDateTime> getHeldOn();

    Optional<LocalDateTime> getResearvedOn();

    String getSeatHoldId();

    void setSeatHoldId(String seatHoldId);
    
    void addSeats(List<ISeat> seats);

    public void researve();
    
    String getResearvationCode();
}
