package com.joyveb.cassandra.bean;

import org.springdata.cassandra.mapping.Id;
import org.springdata.cassandra.mapping.Indexed;
import org.springdata.cassandra.mapping.Table;

@Table(name = "t_core_bo")
public class BoBean {
 
	@Id
	private BOKey key;
	
	@Indexed
	private Integer isvalid = 1;
	
	private String amount;

	public BOKey getKey() {
		return key;
	}

	public void setKey(BOKey key) {
		this.key = key;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
