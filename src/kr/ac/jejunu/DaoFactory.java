package kr.ac.jejunu;

/**
 * Created by Cheechyo on 2017. 4. 21..
 */
public class DaoFactory {
    public ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }

    public ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
