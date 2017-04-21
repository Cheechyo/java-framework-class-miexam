package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Cheechyo on 2017. 4. 21..
 */
@Configuration
public class DaoFactory {
    @Bean
    public ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }
    @Bean
    public ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
