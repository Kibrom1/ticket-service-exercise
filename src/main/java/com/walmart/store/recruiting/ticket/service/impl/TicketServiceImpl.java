package com.walmart.store.recruiting.ticket.service.impl;

import com.walmart.store.recruiting.ticket.domain.DataSource;
import com.walmart.store.recruiting.ticket.domain.ISeat;
import com.walmart.store.recruiting.ticket.domain.SeatHold;
import com.walmart.store.recruiting.ticket.domain.Venue;
import com.walmart.store.recruiting.ticket.service.TicketService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * A ticket service implementation.
 */
public class TicketServiceImpl implements TicketService {

	private int seatsAvailable;
	private int seatsReserved;
	private Map<String, SeatHold> seatHoldMap = new HashMap<>();

	public TicketServiceImpl(Venue venue) {
		seatsAvailable = venue.getMaxSeats();
	}

	@Override
	public int numSeatsAvailable(Optional<Integer> level) {

		return (int) DataSource
				.getInstance()
				.getAllSeats()
				.stream()
				.filter(s -> (!level.isPresent() || s.getLevelId() == level
						.get()) && s.isAvailable()).count();
	}

	public int numSeatsReserved() {
		return this.seatsReserved;
	}

	@Override
	public Optional<String> reserveSeats(String seatHoldId) {
		String optionalReservation;

		SeatHold seatHold = (SeatHold) DataSource.getInstance().getSeatHold(
				seatHoldId);
		seatHold.researve();
		optionalReservation = seatHold.getResearvationCode();

		return optionalReservation;
	}

	@Override
	public SeatHold findAndHoldSeats(int numSeats, Optional<Integer> minLevel,
			Optional<Integer> maxLevel) {
		List<ISeat> seats = DataSource
				.getInstance()
				.getAllSeats()
				.stream()
				.filter(s -> s.isAvailable()
						&& (!minLevel.isPresent() || s.getLevelId() >= minLevel
								.get())
						&& (!maxLevel.isPresent() || s.getLevelId() <= maxLevel
								.get()))
				.sorted(Comparator.comparing(s -> s.getLevelId()))
				.limit(numSeats).collect(Collectors.toList());

		Optional<SeatHold> seatsHeld = Optional.empty();
		SeatHold seatHold = new SeatHold("one", numSeats);
		seatHold.addSeats(seats);
		DataSource.getInstance().addSeatHold(seatHold);

		return seatHold;
	}

	private String generateId() {
		return UUID.randomUUID().toString();
	}

}
