package test.category;

import com.category.model.Category;
import com.category.service.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CategoryServiceImpl.class, TestCategoryConfiguraion.class})
public class CategoryServiceTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void testSuccessSave() {
        when(categoryService.save(any(Category.class))).thenReturn(buildProduct());
        Category category = categoryService.save(buildProduct());
        assertNotNull(category);
    }

    private Category buildProduct() {
        return Category.builder()
                .id(new Long("4"))
                .name("Product name")
                .build();
    }
}
