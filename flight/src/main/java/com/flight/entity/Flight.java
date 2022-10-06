package com.flight.entity;

import java.time.LocalDate;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;


@Document(collection = "flight")
public class Flight {

	@Transient
	public static final  String SEQUENCE_NAME ="flight_sequence";

	@Id
	@NotNull(message = "flight id should not be empty")
//	@Max(message = "Flight number cannot exceed 5 digits")
	
	private int flightId;

	@NotNull(message = "From location  should not be empty")
	@Size(min= 3, message = "Location should be minimum of 3 characters")
	private String fromLocation;

	@NotNull(message = "destination should not be empty")
	@Size(min= 3, message = "destination should be minimum of 3 characters")
	private String destination;

	@NotNull(message = "date should not be empty")
	@FutureOrPresent(message = "please select present or future date")
	private LocalDate date;

	@NotNull(message = "flightname should not be empty")
	@Size(min= 3, message = "flightname should be minimum of 3 characters")
	private String flightName;

	@NotNull(message = "flightType should not be empty")
	@Size(min= 3, message = "flightType should be minimum of 3 characters")
	private String flightType;

	@NotNull(message = "farePrice should not be empty")
	@Min(value = 1000, message = "farePrice should be minimum of 1000")
	private double farePrice;
	
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getFlightName() {

		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public double getFarePrice() {
		return farePrice;
	}

	public void setFarePrice(double farePrice) {
		this.farePrice = farePrice;
	}

	public Flight(int flightId, String fromLocation, String destination, LocalDate date, String flightName,
				  String flightType, double farePrice) {
		super();
		this.flightId = flightId;
		this.fromLocation = fromLocation;
		this.destination = destination;
		this.date = date;
		this.flightName = flightName;

		this.flightType = flightType;
		this.farePrice=farePrice;
	}
	
	public Flight() {
		super();
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
}
