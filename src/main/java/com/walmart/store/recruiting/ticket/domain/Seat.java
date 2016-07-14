package com.walmart.store.recruiting.ticket.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Seat {

	private String seatId;
	private int levelId;
	private String seatNumber;
	private SeatHold seatHold;

	public Seat(String seatId, int levelId, String seatNumber, SeatHold seatHold) {
		this.seatId = seatId;
		this.levelId = levelId;
		this.seatNumber = seatNumber;
		this.seatHold = seatHold;
	}

	public SeatHold getSeatHold() {
		// TODO Auto-generated method stub
		return seatHold;
	}

	
	public void setSeatHold(SeatHold seatHold) {
		// TODO Auto-generated method stub

		this.seatHold = seatHold;
	}

		public String getSeatId() {
		// TODO Auto-generated method stub
		return seatId;
	}

	
	public void setSeatId(String seatId) {
		// TODO Auto-generated method stub

		this.seatId = seatId;

	}

	
	public String getSeatNumber() {
		// TODO Auto-generated method stub
		return this.seatNumber;

	}

	public void setSeatNumber(String seatNumber) {
		// TODO Auto-generated method stub

		this.seatNumber = seatNumber;
	}

	public boolean isAvailable() {
		return (this.getSeatHold() == null || (this.getSeatHold()
				.getResearvedOn() == null || !this.getSeatHold()
				.getResearvedOn().isPresent())
				&& ChronoUnit.SECONDS.between(this.getSeatHold().getHeldOn()
						.get(), LocalDateTime.now()) > '5');// Specifying the
															// number of seconds
	}

	public int getLevelId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLevelId(int levelId) {
		// TODO Auto-generated method stub

		this.levelId = levelId;
	}

}
