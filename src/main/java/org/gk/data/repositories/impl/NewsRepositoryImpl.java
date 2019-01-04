package org.gk.data.repositories.impl;

import org.gk.data.model.News;
import org.gk.data.repositories.interfaces.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<News> getNews(long count) {
        return null;
    }
}
