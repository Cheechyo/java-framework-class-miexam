package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        ProductDao productDao = new ProductDao();
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Long id = randomGernarateId();
        String title = "제주감귤";
        Integer price = 15000;
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        ProductDao productDao = new ProductDao();
        productDao.add(product);
        product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    private Long randomGernarateId() {
        Random random = new Random();
        return new Long(random.nextInt(Integer.MAX_VALUE));
    }
}
