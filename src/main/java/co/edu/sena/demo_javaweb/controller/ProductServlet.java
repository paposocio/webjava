package co.edu.sena.demo_javaweb.controller;

import co.edu.sena.demo_javaweb.model.beans.Product;
import co.edu.sena.demo_javaweb.model.repository.ProductRepositoryImpl;
import co.edu.sena.demo_javaweb.model.repository.Repository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", value = "/register-product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Load the JDBC driver manually
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Collect all form data
        String productName = request.getParameter("productName");
        String productValueString = request.getParameter("productValue");
        String categoryIdString = request.getParameter("categoryId");

        // Convert parameters to their corresponding types
        int productValue = Integer.parseInt(productValueString);
        int categoryId = Integer.parseInt(categoryIdString);

        // Create an instance of the product with the obtained parameters
        Product product = new Product(null, productName, productValue, categoryId);

        // Save the product in the database using the repository
        Repository<Product> repository = new ProductRepositoryImpl();
        boolean success = true;
        try {
            repository.saveObj(product);
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }

        // Prepare an information message for the user about the success or failure of the operation
        if (!success) {
            System.out.println("Ocurrió un error");
        } else {
            request.getRequestDispatcher("/views/success.jsp").forward(request, response);
        }
    }
}
