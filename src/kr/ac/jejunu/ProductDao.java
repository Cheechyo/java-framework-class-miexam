package kr.ac.jejunu;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class ProductDao {
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        Object[] params = {id};
        String sql = "select * from product where id = ?";
        return jdbcTemplate.query(sql, params, resultSet -> {
            Product product = null;
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getInt("price"));
            }
            return product;
        });
    }

    public void add(Product product) throws SQLException, ClassNotFoundException {
        Object[] params = {product.getId(), product.getTitle(), product.getPrice()};
        String sql = "INSERT INTO product VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, params);
    }

    public void delete(Product product) throws SQLException {
        Object[] params = {product.getId()};
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, params);
    }

    public void update(Product product) throws SQLException {
        Object[] params = {product.getTitle(), product.getPrice(), product.getId()};
        String sql = "UPDATE product SET title = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, params);
    }

}
