package org.gk.controllers;

import org.gk.business.data.model.News;
import org.gk.business.data.repositories.interfaces.NewsRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


public class HomeControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void homeModel() throws Exception {
        List<News> news = Stream.iterate(0L, i-> i)
                .limit(20)
                .map(i -> new News(i, "Title","News" + i, new Date(), 1.0, 1.0))
                .collect(Collectors.toList());
        NewsRepository newsRepository = mock(NewsRepository.class);
        when(newsRepository.getNews(20)).thenReturn(news);

        HomeController homeController = new HomeController(newsRepository);
        MockMvc mockMvc = standaloneSetup(homeController)
                .build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("newsList"))
                .andExpect(model().attribute("newsList", hasItems(news.toArray())));
    }
}