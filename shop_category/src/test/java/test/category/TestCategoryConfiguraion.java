package test.category;

import com.category.repository.CategoryRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

@TestConfiguration
public class TestCategoryConfiguraion {

    @MockBean
    private CategoryRepository categoryRepository;
}
