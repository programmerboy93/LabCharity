package pl.coderslab.charity.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTestJUnit4 {

    private static final String PAGE_HOME = "index";
    private static MockMvc mockMvc;

    @Test
    public void home_Action_With_Mock_Mvc() throws Exception {
        mockMvc = standaloneSetup(HomeController.class).build();
        mockMvc.perform(MockMvcRequestBuilders.get(""))
                .andExpect(view().name(PAGE_HOME));
    }
}