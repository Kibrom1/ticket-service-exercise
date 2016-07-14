package com.walmart.store.recruiting.ticket.domain;

/**
 * This class represents a venue where customers can buy tickets to see a show.
 * Our Venue seating is rectangular to simplify things.
 */
public class Venue {

	private final int id;
	private final int rows;
	private final int seatsPerRow;
	private int levelId;
	private String levelName;

	public Venue(int id, int rows, int seatsPerRow, int levelId,
			String levelName) {
		this.id = id;
		this.rows = rows;
		this.seatsPerRow = seatsPerRow;
		this.levelId = levelId;
		this.levelName = levelName;

	}

	
	/**
	 * @return the number of rows of seats in the venue
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @return the number of seats in each row
	 */
	public int getSeatsPerRow() {
		return seatsPerRow;
	}

	/**
	 * @return the total number of seats in the venue
	 */
	public int getMaxSeats() {
		return rows * seatsPerRow;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Venue venue = (Venue) o;

		return id == venue.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public int getLevelId() {
		// TODO Auto-generated method stub
		return levelId;
	}

	public String getLevelName() {
		// TODO Auto-generated method stub
		return levelName;
	}

	
	public int getSeatsInRow() {
		// TODO Auto-generated method stub
		return seatsPerRow;
	}

		public void setLevelId(int levelId) {
		// TODO Auto-generated method stub

		this.levelId = levelId;
	}

	
	public void setLevelName(String levelName) {
		// TODO Auto-generated method stub

		this.levelName = levelName;

	}

}
