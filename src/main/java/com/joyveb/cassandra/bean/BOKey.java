package com.joyveb.cassandra.bean;

import java.io.Serializable;

import org.springdata.cassandra.cql.core.KeyPart;
import org.springdata.cassandra.mapping.Embeddable;
import org.springdata.cassandra.mapping.KeyColumn;

@Embeddable
public class BOKey implements Serializable{

	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 1)
	private String merchantid;
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 2)
	private String ltype;
	@KeyColumn(keyPart = KeyPart.PARTITION, ordinal = 3)
	private String period;
	@KeyColumn(keyPart = KeyPart.CLUSTERING, ordinal = 1)
	private String messageid;
	@KeyColumn(keyPart = KeyPart.CLUSTERING, ordinal = 2)
	private String orderno;
	@KeyColumn(keyPart = KeyPart.CLUSTERING, ordinal = 3)
	private String caskey;
	
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	public String getLtype() {
		return ltype;
	}
	public void setLtype(String ltype) {
		this.ltype = ltype;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getCaskey() {
		return caskey;
	}
	public void setCaskey(String caskey) {
		this.caskey = caskey;
	}
	
}
