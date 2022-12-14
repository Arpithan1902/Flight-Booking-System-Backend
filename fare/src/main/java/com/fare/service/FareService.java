package com.fare.service;

import com.fare.entity.Fare;

import java.util.List;
import java.util.Optional;

public interface FareService {
	
	public Fare saveFare(Fare fare);
	public Fare getFareById(int fareId);
	public Fare modifyFare(Fare fare);
	public void deleteFare(int fareId);
	public List<Fare> getAllFares();
	public int getSequenceNumber(String sequenceName);
	public Fare getFareByPrice(double farePrice) ;
}
