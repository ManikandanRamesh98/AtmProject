package com.atm.models;

public class TransActionsModel {
private int id;
private Long userAccnoLong;
private int transActionAmount;
private String transActionAt;
private String transActionType;
private String moneyTransfer;


public TransActionsModel() {
	
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public TransActionsModel(int transActionAmount, String transActionAt, String transActionType) {
	super();
	this.transActionAmount = transActionAmount;
	this.transActionAt = transActionAt;
	this.transActionType = transActionType;
}


public Long getUserAccnoLong() {
	return userAccnoLong;
}


public void setUserAccnoLong(Long userAccnoLong) {
	this.userAccnoLong = userAccnoLong;
}


public int getTransActionAmount() {
	return transActionAmount;
}


public void setTransActionAmount(int transActionAmount) {
	this.transActionAmount = transActionAmount;
}


public String getTransActionAt() {
	return transActionAt;
}


public void setTransActionAt(String transActionAt) {
	this.transActionAt = transActionAt;
}


public String getTransActionType() {
	return transActionType;
}


public void setTransActionType(String transActionType) {
	this.transActionType = transActionType;
}


public String getMoneyTransfer() {
	return moneyTransfer;
}


public void setMoneyTransfer(String moneyTransfer) {
	this.moneyTransfer = moneyTransfer;
}


@Override
public String toString() {
	return "TransActionsModel [id=" + id + ", userAccnoLong=" + userAccnoLong + ", transActionAmount="
			+ transActionAmount + ", transActionAt=" + transActionAt + ", transActionType=" + transActionType
			+ ", moneyTransfer=" + moneyTransfer + "]";
}


}
