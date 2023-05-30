package co.edu.sena.demo_javaweb.controller;

import co.edu.sena.demo_javaweb.model.beans.Category;
import co.edu.sena.demo_javaweb.model.repository.CategoryRepositoryImpl;
import co.edu.sena.demo_javaweb.model.repository.Repository;
import co.edu.sena.demo_javaweb.util.ConnectionPool;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CategoryServlet", value = "/register-category")
public class CategoryServlet extends HttpServlet {
    private Repository<Category> categoryRepository;

    @Override
    public void init() throws ServletException {
        try {
            // Crear una instancia del repositorio de categorías
            categoryRepository = new CategoryRepositoryImpl();
        } catch (Exception e) {
            throw new ServletException("Error al inicializar el repositorio de categorías", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el nombre de la categoría enviado desde el formulario
        String categoryName = request.getParameter("categoryName");

        try {
            // Crear una instancia de la categoría con el nombre obtenido
            Category category = new Category(null, categoryName);

            // Guardar la categoría en la base de datos utilizando el repositorio
            try {
                categoryRepository.saveObj(category);
            } catch (SQLException e) {
                throw new ServletException("Error al registrar la categoría", e);
            }

            // Redireccionar a una página de éxito o mostrar un mensaje de éxito
            response.sendRedirect("success.jsp");
        } catch (ServletException e) {
            throw e;
        } catch (Exception e) {
            throw new ServletException("Error al procesar la solicitud", e);
        }
    }

    @Override
    public void destroy() {
        // Cerrar la conexión con la base de datos al finalizar
        try {
            ConnectionPool.getInstance().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

