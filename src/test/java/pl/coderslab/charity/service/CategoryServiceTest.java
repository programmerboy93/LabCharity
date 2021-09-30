package pl.coderslab.charity.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql("/init.sql")
@Transactional
public class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;


    @Ignore
    public void setUp(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("ubrania, które nadają się do ponownego użycia"));
        categoryList.add(new Category("ubrania, do wyrzucenia"));
        categoryList.add(new Category("zabawki"));
        categoryList.add(new Category("książki"));
        categoryList.add(new Category("inne"));
        categoryRepository.saveAll(categoryList);
    }

    @Test
    public void given_five_categories_then_return_five_object(){
        assertEquals(5,categoryRepository.findAll().size());
    }

    @Test
    public void delete_one_categories(){
        categoryRepository.deleteById(1L);
        assertEquals(4,categoryRepository.findAll().size());
    }


}