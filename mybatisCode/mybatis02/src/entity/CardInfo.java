package entity;

import java.util.Date;

public class CardInfo {
	private String carId;
	private String currency;
	private String saveType;
	private Date openTime;
	private float openMoney;
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSaveType() {
		return saveType;
	}
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public float getOpenMoney() {
		return openMoney;
	}
	public void setOpenMoney(float openMoney) {
		this.openMoney = openMoney;
	}
}
