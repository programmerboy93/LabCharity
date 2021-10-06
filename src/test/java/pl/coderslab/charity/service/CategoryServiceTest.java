package pl.coderslab.charity.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.repository.CategoryRepository;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void delete_one_categories() {
        categoryRepository.deleteById(1L);
        assertEquals(4, categoryRepository.findAll().size());
    }

    @Test
    public void given_five_categories_then_return_five_object() {
        assertEquals(5, categoryRepository.findAll().size());
    }
}