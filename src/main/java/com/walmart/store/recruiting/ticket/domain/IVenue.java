package com.walmart.store.recruiting.ticket.domain;

public interface IVenue {
	int getLevelId();

	String getLevelName();

	//double getPrice();

	int getRows();

	int getSeatsInRow();

	void setLevelId(int levelId);

	void setLevelName(String levelName);

	//void setPrice(double price);


}
