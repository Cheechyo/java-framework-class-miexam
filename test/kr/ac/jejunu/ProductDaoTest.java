package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDaoTest {

    private ProductDao productDao;

    @Before
    public void setup(){
        ApplicationContext context = new GenericXmlApplicationContext("spring-context.xml");
        productDao = context.getBean(ProductDao.class);
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

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
        productDao.add(product);
        product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        Long id = randomGernarateId();
        String title = "제주감귤";
        Integer price = 15000;
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        productDao.add(product);

        product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));

        String anotherTitle = "제주흑돼지";
        Integer anotherPrice = 30000;
        product.setTitle(anotherTitle);
        product.setPrice(anotherPrice);
        productDao.update(product);

        product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(anotherTitle, is(product.getTitle()));
        assertThat(anotherPrice, is(product.getPrice()));
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        Long id = randomGernarateId();
        String title = "제주감귤";
        Integer price = 15000;
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        productDao.add(product);
        productDao.delete(product);
        product = productDao.get(id);
        assertThat(product, is(nullValue()));
    }

    private Long randomGernarateId() {
        Random random = new Random();
        return new Long(random.nextInt(Integer.MAX_VALUE));
    }
}
