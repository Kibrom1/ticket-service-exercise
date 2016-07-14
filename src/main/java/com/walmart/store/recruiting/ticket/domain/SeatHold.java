package com.walmart.store.recruiting.ticket.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * This POJO contains the data relevant to a successful seat hold request,
 * including the seat hold id which may be used later to permanently reserve the
 * seats.
 */
public class SeatHold {

	private String id;
	private int numSeats;
	private String seatNumber;
	// private SeatHold seatHold;
	private Optional<LocalDateTime> heldOn;
	private Optional<LocalDateTime> researvedOn;
	private String researvationCode;

	/*
	 * constructor that have seats the held on date
	 */
	public SeatHold(String holdId, int numSeats) {
		this.id = holdId;
		this.numSeats = numSeats;
		this.heldOn = Optional.of(LocalDateTime.now());
	}

	/**
	 * all setters and getters
	 */
	public int getNumSeats() {
		return numSeats;
	}

	public String getId() {
		return id;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		SeatHold seatHold = (SeatHold) o;

		return id.equals(seatHold.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}


	public Optional<LocalDateTime> getHeldOn() {
		return heldOn;
	}


	public Optional<LocalDateTime> getResearvedOn() {
		return researvedOn;
	}

	public String getSeatHoldId() {
		return id;
	}

	
	public void researve() {
		this.researvedOn = Optional.of(LocalDateTime.now());
		this.researvationCode = "" + this.researvedOn.get().getYear()
				+ this.researvedOn.get().getMonth()
				+ this.researvedOn.get().getDayOfMonth()
				+ this.researvedOn.get().getHour()
				+ this.researvedOn.get().getMinute()
				+ this.researvedOn.get().getSecond();

	}
	
	public String getResearvationCode() {
		// TODO Auto-generated method stub
		return researvationCode;
	}

	
	public void setSeatHoldId(String id) {
		// TODO Auto-generated method stub

		this.id = id;
	}

	public void addSeats(List<Seat> seats) {
		// TODO Auto-generated method stub

		seats.stream().forEach(s -> s.setSeatHold(this));
	}

}
