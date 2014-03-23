package com.joyveb.cassandra.use;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.datastax.driver.core.Query;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.common.base.Function;
import com.google.common.collect.Iterators;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> fromIterator = new ArrayList<>();
		fromIterator.add("id1");
		fromIterator.add("id2");
		Iterator<Query> it = Iterators.transform(fromIterator.iterator(), new Function<Object, Query>() {
			@Override
			public Query apply(Object input) {
				System.out.println(input);
				return QueryBuilder.insertInto("table");
			}
		});
		while(it.hasNext()){
			Query query = it.next();
			System.out.println(query.toString());
		}
	}
}
