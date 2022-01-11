package com.atm.daoimpl;

import com.atm.models.WithdrawModel;

public class Main {
public static void main(String[] args) throws Exception {
	WithdrawImpl withdrawImpl = new WithdrawImpl();
	WithdrawModel withdrawModel = new WithdrawModel();
	withdrawModel.setUser_acc_no(12345678901l);
	System.out.println(withdrawImpl.checkwithdrawlimit(withdrawModel));
}
}
