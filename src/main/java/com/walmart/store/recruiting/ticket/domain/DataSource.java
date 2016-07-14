package com.walmart.store.recruiting.ticket.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataSource {

	private static DataSource instance;

	private DataSource() {
	}

	public static DataSource getInstance() {
		if (instance == null) {
			instance = new DataSource();
			initData();
		}

		return instance;
	}

	private static List<Venue> venues = new ArrayList<>();
	private static List<Seat> seats = new ArrayList<>();
	private static List<SeatHold> seatHolds = new ArrayList<>();

	private static void initData() {
		venues.add(new Venue(1, 40, 75, 75, "First"));
		venues.add(new Venue(2, 75, 40, 100, "Second"));
		venues.add(new Venue(3, 50, 40, 75, "Third"));
		venues.add(new Venue(4, 40, 15, 100, "Fourth"));

		int seatId = 1;
		for (Venue venue : venues) {
			int seatNumber = 1;
			for (int i = 0; i < venue.getSeatsInRow() * venue.getRows(); i++) {
				seats.add(new Seat("" + seatId++, venue.getLevelId(), venue
						.getLevelName() + seatNumber++, null));
			}
		}
	}

	public List<SeatHold> getAllSeatHolds() {
		return seatHolds;
	}

	public SeatHold getSeatHold(String setHoldId) {
		return seatHolds.stream()
				.filter(sh -> sh.getSeatHoldId().equals(setHoldId)).findFirst()
				.get();
	}

	
	public List<Seat> getAllSeats() {
		return seats;
	}

	public void addSeatHold(SeatHold seatHold) {
		Optional<String> maxId = seatHolds.stream()
				.map(sh -> sh.getSeatHoldId())
				.max(Comparator.comparing(shi -> shi));
		if (maxId.isPresent()) {
			seatHold.setSeatHoldId(maxId.get());
		} else {
			seatHold.setSeatHoldId(1 + "");
		}
		seatHolds.add(seatHold);
	}
}
