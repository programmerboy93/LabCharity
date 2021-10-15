package pl.coderslab.charity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

@Component
public class CategoryConverter implements Converter<Long, Category> {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category convert(Long id) {
        return categoryRepository.findById(id).get();
    }
}
