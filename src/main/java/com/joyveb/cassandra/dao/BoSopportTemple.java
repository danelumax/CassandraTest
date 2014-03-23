package com.joyveb.cassandra.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springdata.cassandra.convert.MappingCassandraConverter;
import org.springdata.cassandra.core.CassandraOperations;
import org.springdata.cassandra.mapping.CassandraPersistentEntity;
import org.springdata.cassandra.repository.CassandraRepository;
import org.springdata.cassandra.repository.query.CassandraEntityInformation;
import org.springdata.cassandra.repository.support.MappingCassandraEntityInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joyveb.cassandra.bean.BOKey;
import com.joyveb.cassandra.bean.BoBean;

@Repository
public class BoSopportTemple implements CassandraRepository<BoBean, BOKey> {

	@Autowired
	private CassandraOperations cassandraTemplate;
	@Resource(name = "cassandra-converter")
	private MappingCassandraConverter converter;
	private CassandraEntityInformation<BoBean, BOKey> entityInformation;

	@PostConstruct
	public void init() {
		CassandraPersistentEntity<?> entity = converter.getMappingContext()
				.getPersistentEntity(BoBean.class);
		entityInformation = new MappingCassandraEntityInformation<BoBean, BOKey>(
				(CassandraPersistentEntity<BoBean>) entity);
	}

	@Override
	public <S extends BoBean> S save(S entity) {
		cassandraTemplate.save(entity);
		return entity;
	}

	@Override
	public <S extends BoBean> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		 cassandraTemplate.saveInBatch(entities);
		 return entities;
	}

	@Override
	public BoBean findOne(BOKey id) {
		// TODO Auto-generated method stub
		return cassandraTemplate.findById(entityInformation.getJavaType(), id);
	}

	@Override
	public boolean exists(BOKey id) {
		// TODO Auto-generated method stub
		return cassandraTemplate.exists(entityInformation.getJavaType(), id);
	}

	@Override
	public Iterable<BoBean> findAll() {
		// TODO Auto-generated method stub
		return cassandraTemplate.findAll(entityInformation.getJavaType());
	}

	@Override
	public Iterable<BoBean> findAll(Iterable<BOKey> ids) {
		// TODO Auto-generated method stub
		return cassandraTemplate.findAll(entityInformation.getJavaType(), ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		// cassandraTemplate.countAll(entityClass)
		return 0;
	}

	@Override
	public void delete(BOKey id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(BoBean entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends BoBean> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoBean> findByPartitionKey(BOKey id) {
		// TODO Auto-generated method stub
		return null;
	}

}
