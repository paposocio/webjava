package co.edu.sena.demo_javaweb.controller;

import co.edu.sena.demo_javaweb.model.beans.Category;
import co.edu.sena.demo_javaweb.model.repository.CategoryRepositoryImpl;
import co.edu.sena.demo_javaweb.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CategoryServlet", value = "/register-category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Load the JDBC driver manually
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //collect all form data
        String category_name = request.getParameter("category_name");

        //fill it up in a user bean
        Category category = new Category();
        category.setCategoryName(category_name);

        //call repository tayer and save the user object to do
        Repository<Category> repository = new CategoryRepositoryImpl();
        boolean success = true;
        try{
            repository.saveObj(category);
        }catch (SQLException e){
            e.printStackTrace();
            success = false;
        }

        //prepare an information message for user about success or failure of the operation
        if(!success){
            System.out.println("Ocurrió un error");
        }else {
            request.getRequestDispatcher("/views/success.jsp").forward(request, response);
        }
    }
}

