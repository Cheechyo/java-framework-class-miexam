package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Cheechyo on 2017. 4. 21..
 */
public class ProductUpdateStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Connection connection, Object o) throws SQLException {
        Product product = (Product) o;
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET title = ?, price = ? WHERE id = ?");
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setLong(3, product.getId());
        return preparedStatement;
    }
}
