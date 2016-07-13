package com.walmart.store.recruiting.ticket.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Seat implements ISeat {

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

	@Override
	public SeatHold getSeatHold() {
		// TODO Auto-generated method stub
		return seatHold;
	}

	@Override
	public void setSeatHold(SeatHold seatHold) {
		// TODO Auto-generated method stub

		this.seatHold = seatHold;
	}

	@Override
	public String getSeatId() {
		// TODO Auto-generated method stub
		return seatId;
	}

	@Override
	public void setSeatId(String seatId) {
		// TODO Auto-generated method stub

		this.seatId = seatId;

	}

	@Override
	public String getSeatNumber() {
		// TODO Auto-generated method stub
		return this.seatNumber;

	}

	@Override
	public void setSeatNumber(String seatNumber) {
		// TODO Auto-generated method stub

		this.seatNumber = seatNumber;
	}

	@Override
	public boolean isAvailable() {
		return (this.getSeatHold() == null || (this.getSeatHold()
				.getResearvedOn() == null || !this.getSeatHold()
				.getResearvedOn().isPresent())
				&& ChronoUnit.SECONDS.between(this.getSeatHold().getHeldOn()
						.get(), LocalDateTime.now()) > '5');// Specifying the
															// number of seconds
	}

	@Override
	public int getLevelId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLevelId(int levelId) {
		// TODO Auto-generated method stub

		this.levelId = levelId;
	}

}
