package co.edu.sena.demo_javaweb.model.repository;

import co.edu.sena.demo_javaweb.model.beans.Category;
import co.edu.sena.demo_javaweb.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository<Category> {
    private String sql = null;

    @Override
    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategoryId(rs.getInt("category_id"));
        category.setCategoryName(rs.getString("category_name"));
        return category;
    }

    @Override
    public List<Category> listAllObj() throws SQLException {
        sql = "SELECT category_id, category_name FROM categories ORDER BY category_name";
        List<Category> categories = new ArrayList<>();

        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Category category = createObj(rs);
                categories.add(category);
            }
        }

        return categories;
    }

    @Override
    public Category byIdObj(Integer id) throws SQLException {
        sql = "SELECT category_id, category_name FROM categories WHERE category_id = ?";
        Category category = null;

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    category = createObj(rs);
                }
            }
        }

        return category;
    }

    @Override
    public Integer saveObj(Category category) throws SQLException {
        int rowsAffected = 0;

        if (category.getCategoryId() != null && category.getCategoryId() > 0) {
            sql = "UPDATE categories SET category_name = ? WHERE category_id = ?";
        } else {
            sql = "INSERT INTO categories (category_name) VALUES (?)";
        }

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, category.getCategoryName());

            if (category.getCategoryId() != null && category.getCategoryId() > 0) {
                ps.setInt(2, category.getCategoryId());
            }

            rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Error");
            }

            if (category.getCategoryId() == null) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        category.setCategoryId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Error");
                    }
                }
            }
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "DELETE FROM categories WHERE category_id = ?";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
