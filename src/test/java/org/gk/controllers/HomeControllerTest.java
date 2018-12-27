package org.gk.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class HomeControllerTest {

    private HomeController homeController;

    @Before
    public void setUp() throws Exception {
        homeController = new HomeController();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void home() {
        assertEquals("home", homeController.home());
    }
}