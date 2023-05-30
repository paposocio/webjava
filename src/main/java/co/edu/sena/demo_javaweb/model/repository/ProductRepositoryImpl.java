package co.edu.sena.demo_javaweb.model.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import co.edu.sena.demo_javaweb.util.ConnectionPool;
import co.edu.sena.demo_javaweb.model.beans.Product;
public class ProductRepositoryImpl implements Repository<Product> {
    @Override
    public List<Product> listAllObj() throws SQLException {
        List<Product> products = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM products";
            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Product product = createObj(resultSet);
                    products.add(product);
                }
            }
        }

        return products;
    }

    @Override
    public Product byIdObj(Integer id) throws SQLException {
        Product product = null;

        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = createObj(resultSet);
                }
            }
        }

        return product;
    }

    @Override
    public Integer saveObj(Product product) throws SQLException {
        Integer generatedId = null;

        String query = "INSERT INTO products (product_name, product_value, categoryid) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getProductValue());
            preparedStatement.setInt(3, product.getCategoryId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }
        }

        return generatedId;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Product createObj(ResultSet rs) throws SQLException {
        int productId = rs.getInt("product_id");
        String productName = rs.getString("product_name");
        int productValue = rs.getInt("product_value");
        int categoryId = rs.getInt("categoryid");

        return new Product(productId, productName, productValue, categoryId);
    }
}

