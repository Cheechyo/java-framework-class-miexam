package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Cheechyo on 2017. 4. 21..
 */
public class ProductGetStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Connection connection, Object o) throws SQLException {
        Long id = (Long) o;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
