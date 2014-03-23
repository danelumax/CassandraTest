package com.joyveb.cassandra.use;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joyveb.cassandra.bean.BOKey;
import com.joyveb.cassandra.bean.BoBean;
import com.joyveb.cassandra.dao.BoSopportTemple;

@Component
public class BoDaoCassandraTempleUse {

	@Autowired
	private BoSopportTemple boSopportTemple;
	@Resource
	private BeanProxy beanProxy;
	@Resource
	private ListableBeanFactory beanFactory;
	
	@PostConstruct
	public void start(){
		BOKey key = new BOKey();
		key.setLtype("QGSLTO");
		key.setMerchantid("666666");
		key.setMessageid("123456789");
		key.setPeriod("2012001");
		BoBean bo = new BoBean();
		bo.setKey(key);
		bo.setAmount("12121");
		boSopportTemple.save(bo);
		System.out.println("≤Â»Î≥…π¶...");
		BoBean result = boSopportTemple.findOne(key);
		System.out.println(result.getAmount());
	}
}
