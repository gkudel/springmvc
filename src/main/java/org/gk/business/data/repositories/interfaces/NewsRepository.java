package org.gk.business.data.repositories.interfaces;

import org.gk.business.data.model.News;

import java.util.List;

public interface NewsRepository {
    List<News> getNews(long count);
}
