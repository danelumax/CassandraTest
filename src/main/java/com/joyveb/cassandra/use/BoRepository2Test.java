package com.joyveb.cassandra.use;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.joyveb.cassandra.bean.BOKey;
import com.joyveb.cassandra.bean.BoBean;
import com.joyveb.cassandra.dao.BORepository2;

@Component
public class BoRepository2Test {

	@Resource
	private BORepository2 dao;
	
	@PostConstruct
	public void test(){
		BOKey key = new BOKey();
		key.setLtype("QGSLTO");
		key.setMerchantid("666666");
		key.setMessageid("123456789");
		key.setPeriod("2012001");
		BoBean bo = new BoBean();
		bo.setKey(key);
		bo.setAmount("12121");
		dao.save(bo);
		System.out.println("count::"+dao.count());
	}
}
