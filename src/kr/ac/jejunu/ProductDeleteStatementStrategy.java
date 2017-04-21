package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Cheechyo on 2017. 4. 21..
 */
public class ProductDeleteStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Connection connection, Object o) throws SQLException {
        Product product = (Product)o;
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?");
        preparedStatement.setLong(1, product.getId());
        return preparedStatement;
    }
}
