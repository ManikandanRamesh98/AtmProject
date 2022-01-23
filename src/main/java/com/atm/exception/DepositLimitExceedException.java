package com.atm.exception;

public class DepositLimitExceedException extends Exception{
@Override
public String getMessage() {
	return "DepositLimitExceed.jsp";
}
}
