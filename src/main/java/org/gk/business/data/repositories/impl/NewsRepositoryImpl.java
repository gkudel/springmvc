package org.gk.business.data.repositories.impl;

import org.gk.business.data.model.News;
import org.gk.business.data.repositories.interfaces.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository {
	private static final String SQL_SLECT_NEWS = "SELECT ID, TITLE, MESSAGE, TIME, LATITUDE, LONGITUDE FROM NEWS WHERE ROWNUM() < :rowNumber ";

	@Autowired
	NamedParameterJdbcOperations jdbcOperations;

	@Override
	public List<News> getNews(long count) {
		return jdbcOperations.query(SQL_SLECT_NEWS, new HashMap<String, Object>(){{
			put("rowNumber", count);
		}}, this::mapRow);
	}

	public News mapRow(ResultSet resultSet, int i) throws SQLException {
		return new News(
				resultSet.getLong("ID"),
				resultSet.getString("TITLE"),
				resultSet.getString("MESSAGE"),
				resultSet.getDate("TIME"),
				resultSet.getDouble("LATITUDE"),
				resultSet.getDouble("LONGITUDE")
		);
	}
}
