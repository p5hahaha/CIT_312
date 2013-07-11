package server.hibernate.tableClasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="student.vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_vehicle_generator")
	@SequenceGenerator(name="my_vehicle_generator", sequenceName="student.s1_vehicle")
	@Column(name="vehicle_id", columnDefinition = "INT")
	private int vehicleId;
	
	@Column(name="name", columnDefinition = "VARCHAR2(30)")
	private String name;
	@Column(name="user_id", columnDefinition = "INT")
	private int userId;
	@Column(name="vehicle_year", columnDefinition = "INT")
	private int vehicleYear;
	
	@Column(name="avg_mpg", columnDefinition = "NUMBER")
	private double avgMpg;
	@Column(name="gas_tank_size", columnDefinition = "NUMBER")
	private double gasTankSize;
	@Column(name="current_gas_amount", columnDefinition = "NUMBER")
	private double currentGasAmount;
	@Column(name="current_odometer", columnDefinition = "NUMBER")
	private double currentOdometer;
	
	@Column(name="vehicle", columnDefinition = "VARCHAR2(30)")
	private String vehicle;
	
	@Column(name="created_by", columnDefinition = "INT")
	private String createdBy;
	@Column(name="creation_date", columnDefinition = "DATE")
	private String creationDate;
	@Column(name="last_updated_by", columnDefinition = "INT")
	private String lastUpdatedBy;
	@Column(name="last_update_date", columnDefinition = "DATE")
	private String lastUpdateDate;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(int vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	public double getAvgMpg() {
		return avgMpg;
	}
	public void setAvgMpg(double avgMpg) {
		this.avgMpg = avgMpg;
	}
	public double getGasTankSize() {
		return gasTankSize;
	}
	public void setGasTankSize(double gasTankSize) {
		this.gasTankSize = gasTankSize;
	}
	public double getCurrentGasAmount() {
		return currentGasAmount;
	}
	public void setCurrentGasAmount(double currentGasAmount) {
		this.currentGasAmount = currentGasAmount;
	}
	public double getCurrentOdometer() {
		return currentOdometer;
	}
	public void setCurrentOdometer(double currentOdometer) {
		this.currentOdometer = currentOdometer;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}
