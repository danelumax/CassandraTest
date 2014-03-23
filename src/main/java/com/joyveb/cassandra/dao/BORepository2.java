package com.joyveb.cassandra.dao;

import org.springframework.stereotype.Repository;

import com.joyveb.cassandra.bean.BOKey;
import com.joyveb.cassandra.bean.BoBean;

@Repository
public class BORepository2 extends AbstractCassandraRepository<BoBean, BOKey> {

	public BORepository2() {
		super(BoBean.class);
	}

}
