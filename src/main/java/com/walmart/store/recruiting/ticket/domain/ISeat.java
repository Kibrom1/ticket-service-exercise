package com.walmart.store.recruiting.ticket.domain;

public interface ISeat {

	SeatHold getSeatHold();

	void setSeatHold(SeatHold seatHold);

	String getSeatId();

	void setSeatId(String seatId);

	String getSeatNumber();

	void setSeatNumber(String seatNumber);

	int getLevelId();

	void setLevelId(int levelId);

	public boolean isAvailable();
}
