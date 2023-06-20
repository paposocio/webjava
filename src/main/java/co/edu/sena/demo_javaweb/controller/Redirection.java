package co.edu.sena.demo_javaweb.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "redirection", value = "/redirection")
public class Redirection extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equals("categories")) {
            request.getRequestDispatcher("/views/categories.jsp").forward(request, response);
        } else if (page.equals("products")) {
            request.getRequestDispatcher("/views/products.jsp").forward(request, response);
        } else if (page.equals("start")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

}
