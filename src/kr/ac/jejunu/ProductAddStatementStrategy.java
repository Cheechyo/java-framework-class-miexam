package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Cheechyo on 2017. 4. 21..
 */
public class ProductAddStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Connection connection, Object o) throws SQLException {
        Product product = (Product) o;
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product VALUES(?, ?, ?)");
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2, product.getTitle());
        preparedStatement.setInt(3, product.getPrice());
        return preparedStatement;
    }
}
