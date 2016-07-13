package com.walmart.store.recruiting.ticket.domain;

public interface IVenue {
	int getLevelId();

	String getLevelName();


	int getRows();

	int getSeatsInRow();

	void setLevelId(int levelId);

	void setLevelName(String levelName);



}
