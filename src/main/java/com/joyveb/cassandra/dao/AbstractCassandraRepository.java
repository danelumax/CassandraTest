package com.joyveb.cassandra.dao;

import java.io.Serializable;
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
import org.springframework.util.Assert;

import com.google.common.collect.ImmutableList;

public abstract class AbstractCassandraRepository<T, ID extends Serializable>
		implements CassandraRepository<T, ID> {

	@Autowired
	private CassandraOperations cassandraTemplate;
	@Resource(name = "cassandra-converter")
	private MappingCassandraConverter converter;

	private CassandraEntityInformation<T, ID> entityInformation;
	
	private Class<?> beanClass;
	
	
	public AbstractCassandraRepository(Class<?> clazz) {
		beanClass = clazz;
	}

	@PostConstruct
	public void init() {
		CassandraPersistentEntity<?> entity = converter.getMappingContext()
				.getPersistentEntity(beanClass);
		entityInformation = new MappingCassandraEntityInformation<T, ID>(
				(CassandraPersistentEntity<T>) entity);
	}

	@Override
	public <S extends T> S save(S entity) {
		Assert.notNull(entity, "Entity must not be null!");
		cassandraTemplate.getSaveNewOperation(entity).execute();
		return entity;
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {

		Assert.notNull(entities,
				"The given Iterable of entities must not be null!");
		cassandraTemplate.getSaveNewInBatchOperation(entities).execute();

		if (entities instanceof List) {
			return (List<S>) entities;
		} else {
			return ImmutableList.copyOf(entities);
		}
	}

	@Override
	public T findOne(ID id) {
		Assert.notNull(id, "The given id must not be null!");
		return cassandraTemplate.getFindByIdOperation(
				entityInformation.getJavaType(), id).execute();
	}

	@Override
	public List<T> findByPartitionKey(ID id) {
		Assert.notNull(id, "The given id must not be null!");
		return cassandraTemplate.getFindByPartitionKeyOperation(
				entityInformation.getJavaType(), id).execute();
	}

	@Override
	public boolean exists(ID id) {
		Assert.notNull(id, "The given id must not be null!");
		return cassandraTemplate.getExistsOperation(
				entityInformation.getJavaType(), id).execute();
	}

	@Override
	public long count() {
		Long result = cassandraTemplate.getCountAllOperation(
				entityInformation.getJavaType()).execute();
		return result != null ? result : 0;
	}

	@Override
	public void delete(ID id) {
		Assert.notNull(id, "The given id must not be null!");
		cassandraTemplate.getDeleteByIdOperation(
				entityInformation.getJavaType(), id).execute();
	}

	@Override
	public void delete(T entity) {
		Assert.notNull(entity, "The given entity must not be null!");
		cassandraTemplate.getDeleteOperation(entity).execute();
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		Assert.notNull(entities, "The given Iterable of entities not be null!");
		cassandraTemplate.getDeleteInBatchOperation(entities).execute();
	}

	@Override
	public void deleteAll() {
		cassandraTemplate
				.getDeleteAllOperation(entityInformation.getJavaType())
				.execute();
	}

	@Override
	public List<T> findAll() {
		return cassandraTemplate.getFindAllOperation(
				entityInformation.getJavaType()).execute();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		Assert.notNull(ids, "The given Iterable of ids not be null!");
		return cassandraTemplate.getFindAllOperation(
				entityInformation.getJavaType(), ids).execute();
	}

}
