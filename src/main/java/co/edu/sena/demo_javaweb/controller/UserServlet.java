package co.edu.sena.demo_javaweb.controller;

import co.edu.sena.demo_javaweb.model.beans.User;
import co.edu.sena.demo_javaweb.model.repository.Repository;
import co.edu.sena.demo_javaweb.model.repository.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/register-user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Load the JDBC driver manually
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Collect all form data
        String user_firstname = request.getParameter("user_firstname");
        String user_lastname = request.getParameter("user_lastname");
        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");

        // Fill it up in a User bean
        User user = new User(user_firstname, user_lastname, user_email, user_password);

        // Call repository layer and save the user object
        Repository<User> repository = new UserRepositoryImpl();
        boolean success = true;
        try {
            repository.saveObj(user);
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
