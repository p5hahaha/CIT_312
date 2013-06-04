package test;

import java.io.Serializable;

public class GasStation implements Serializable {

	String country;
	String zip;
	float price;
	String date;
	String address;
	boolean diesel;
	int id;
	float lat;
	float lng;
	String station;	
	String region;
	String city;
	float distance; 

	GasStation(String country, String zip, float price, String date, String address, String diesel,  int id, float lat, float lng, String station,	 String region, String city, float distance){
		this.country = country;
		this.zip = zip;
		this.price = price;
		this.date = date;
		this.address = address;
		setDiesel(diesel);
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.station = station;
		this.region = region;
		this.city = city;
		this.distance = distance;
	}
	boolean setCountry (String country){
		boolean success = false;
		this.country = country;
		success = true;
		return success;
	}
	boolean setZip (String zip){
		boolean success = false;
		this.zip = zip;
		success = true;
		return success;
	}
	boolean setPrice (float price){
		boolean success = false;
		this.price = price;
		success = true;
		return success;
	}
	boolean setDate (String date){
		boolean success = false;
		this.date = date;
		success = true;
		return success;
	}
	boolean setAddress (String address){
		boolean success = false;
		this.address = address;
		success = true;
		return success;
	}
	boolean setDiesel (String diesel){
		boolean success = false;
		if (diesel == "1" || diesel == "0") {
			this.diesel = Boolean.parseBoolean(diesel);
			success = true;
		}
		return success;
	}
}
