package pl.coderslab.charity.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class HomeControllerTest {

    private static final String PAGE_HOME = "index";
    HomeController homeController;

    @Before
    public void setUp(){
        homeController = new HomeController();
    }

    @Test
    public void homeAction() {
        assertThat(homeController.homeAction(),is(PAGE_HOME));
    }
}