package com.atm.models;

public class AtmMoneyManagementModel {
	private int id;
	private Long moneydeposited;
	private Long moneybalance;
	private String depositedat;
	private String agentname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getMoneydeposited() {
		return moneydeposited;
	}

	public void setMoneydeposited(Long moneydeposited) {
		this.moneydeposited = moneydeposited;
	}

	public Long getMoneybalance() {
		return moneybalance;
	}

	public void setMoneybalance(Long moneybalance) {
		this.moneybalance = moneybalance;
	}

	public String getDepositedat() {
		return depositedat;
	}

	public void setDepositedat(String depositedat) {
		this.depositedat = depositedat;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public AtmMoneyManagementModel(int id, Long moneydeposited, Long moneybalance, String depositedat, String agentname) {

		this.id = id;
		this.moneydeposited = moneydeposited;
		this.moneybalance = moneybalance;
		this.depositedat = depositedat;
		this.agentname = agentname;
	}

	@Override
	public String toString() {
		return "AtmMoneyManagement [id=" + id + ", moneydeposited=" + moneydeposited + ", moneybalance=" + moneybalance
				+ ", depositedat=" + depositedat + ", agentname=" + agentname + "]";
	}

	public AtmMoneyManagementModel(Long moneydeposited, String agentname) {

		this.moneydeposited = moneydeposited;
		this.agentname = agentname;
	}
	
	public AtmMoneyManagementModel(Long moneybalance) {

		this.moneybalance = moneybalance;
		
	}
	

}
