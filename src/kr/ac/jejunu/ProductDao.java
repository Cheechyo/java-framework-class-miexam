package kr.ac.jejunu;

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
        StatementStrategy statementStrategy = new ProductGetStatementStrategy();
        Product product = jdbcContext.jdbcContextWithStatementStrategyForGet(id, statementStrategy);
        return product;
    }

    public void add(Product product) throws SQLException, ClassNotFoundException {
        StatementStrategy statementStrategy = new ProductAddStatementStrategy();
        jdbcContext.jdbcContextWithStatementStrategyForAdd(product, statementStrategy);
    }

    public void delete(Product product) throws SQLException {
        StatementStrategy statementStrategy = new ProductDeleteStatementStrategy();
        jdbcContext.jdbcContextWithStatementStrategyForAdd(product, statementStrategy);
    }

    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = new ProductUpdateStatementStrategy();
        jdbcContext.jdbcContextWithStatementStrategyForAdd(product, statementStrategy);
    }
}
