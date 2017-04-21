package kr.ac.jejunu;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    JdbcContext jdbcContext;

    public JdbcContext getJdbcContext() {
        return jdbcContext;
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        Object[] params = {id};
        String sql = "select * from product where id = ?";
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement;
        };
        Product product = jdbcContext.jdbcContextWithStatementStrategyForGet(statementStrategy);
        return product;
    }

    public void add(Product product) throws SQLException, ClassNotFoundException {
        Object[] params = {product.getId(), product.getTitle(), product.getPrice()};
        String sql = "INSERT INTO product VALUES(?, ?, ?)";
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement;
        };
        jdbcContext.jdbcContextWithStatementStrategyForAdd(statementStrategy);
    }

    public void delete(Product product) throws SQLException {
        Object[] params = {product.getId()};
        String sql = "DELETE FROM product WHERE id = ?";
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement;
        };
        jdbcContext.jdbcContextWithStatementStrategyForAdd(statementStrategy);
    }

    public void update(Product product) throws SQLException {
        Object[] params = {product.getTitle(), product.getPrice(), product.getId()};
        String sql = "UPDATE product SET title = ?, price = ? WHERE id = ?";
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement;
        };
        jdbcContext.jdbcContextWithStatementStrategyForAdd(statementStrategy);
    }
}
