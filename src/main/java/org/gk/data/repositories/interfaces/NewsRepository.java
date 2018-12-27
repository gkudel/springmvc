package org.gk.data.repositories.interfaces;

import org.gk.data.model.News;

import java.util.List;

public interface NewsRepository {
    List<News> getNews(long count);
}
