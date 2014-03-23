package com.joyveb.cassandra.dao;

import org.springdata.cassandra.convert.CassandraConverter;
import org.springdata.cassandra.core.CassandraTemplate;
import org.springdata.cassandra.mapping.CassandraPersistentEntity;
import org.springdata.cassandra.repository.query.CassandraEntityInformation;
import org.springdata.cassandra.repository.support.MappingCassandraEntityInformation;
import org.springdata.cassandra.repository.support.SimpleCassandraRepository;

import com.joyveb.cassandra.bean.BOKey;
import com.joyveb.cassandra.bean.BoBean;

//@Repository
public class BORepository extends SimpleCassandraRepository<BoBean, BOKey> {

	public BORepository(
			CassandraEntityInformation<BoBean, BOKey> entityInformation,
			Class<?> repositoryInterface, CassandraTemplate cassandraTemplate) {
		
		super(entityInformation, repositoryInterface, cassandraTemplate);
	}
	
}
