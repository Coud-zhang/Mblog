package com.zkq.jdbcutils;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetHandler<T>{
	public T  handler(ResultSet rs) throws SQLException;
}
