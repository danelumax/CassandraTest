package com.joyveb.cassandra.use;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joyveb.cassandra.bean.BOKey;
import com.joyveb.cassandra.bean.BoBean;
import com.joyveb.cassandra.dao.BoInterface;

//@Component
public class BoDaoUse {
	
	@Autowired
	private BoInterface BbRepository;

	
	@PostConstruct
	public void init() {
		System.out.println("��Ŀ��������������");
		BoBean bo = new BoBean();
		BOKey key = new BOKey();
		key.setLtype("QGLOTO");
		key.setMerchantid("666666");
		key.setMessageid("12121212121");
		key.setPeriod("2012001");
		bo.setKey(key);
		BbRepository.save(bo);
//		cassandraTemplate.save(entity);
		System.out.println("��������....");
//		BoBean result = BbRepository.findOne(key);
//		System.out.println("��������::messageid"+result.getKey().getMessageid());
//		System.out.println("��������::period"+result.getKey().getPeriod());
//		System.out.println("��������::merchatid"+result.getKey().getMerchantid());
	}
}
