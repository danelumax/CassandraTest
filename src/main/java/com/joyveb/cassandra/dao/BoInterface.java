package com.joyveb.cassandra.dao;

import org.springdata.cassandra.repository.CassandraRepository;
import org.springdata.cassandra.repository.config.EnableCassandraRepositories;

import com.joyveb.cassandra.bean.BOKey;
import com.joyveb.cassandra.bean.BoBean;

//@EnableCassandraRepositories
public interface BoInterface extends CassandraRepository<BoBean, BOKey>{

}
