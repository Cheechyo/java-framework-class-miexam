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
        Object[] params = {id};
        String sql = "select * from product where id = ?";
        return jdbcContext.query(sql, params);
    }

    public void add(Product product) throws SQLException, ClassNotFoundException {
        Object[] params = {product.getId(), product.getTitle(), product.getPrice()};
        String sql = "INSERT INTO product VALUES(?, ?, ?)";
        jdbcContext.update(sql, params);
    }

    public void delete(Product product) throws SQLException {
        Object[] params = {product.getId()};
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcContext.update(sql, params);
    }

    public void update(Product product) throws SQLException {
        Object[] params = {product.getTitle(), product.getPrice(), product.getId()};
        String sql = "UPDATE product SET title = ?, price = ? WHERE id = ?";
        jdbcContext.update(sql, params);
    }

}
