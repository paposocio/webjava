package co.edu.sena.demo_javaweb.controller;

import co.edu.sena.demo_javaweb.model.beans.Product;
import co.edu.sena.demo_javaweb.model.repository.ProductRepositoryImpl;
import co.edu.sena.demo_javaweb.model.repository.Repository;
import co.edu.sena.demo_javaweb.util.ConnectionPool;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", value = "/register-product")
public class ProductServlet extends HttpServlet {
    private Repository<Product> productRepository;

    @Override
    public void init() throws ServletException {
        // Crear una instancia del repositorio de productos
        productRepository = new ProductRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros enviados desde el formulario
        String productName = request.getParameter("productName");
        String productValueString = request.getParameter("productValue");
        String categoryIdString = request.getParameter("categoryId");

        try {
            // Validar los parámetros de entrada
            if (productName == null || productName.trim().isEmpty() || productValueString == null || productValueString.trim().isEmpty() || categoryIdString == null || categoryIdString.trim().isEmpty()) {
                throw new ServletException("Error al procesar la solicitud: parámetros incompletos");
            }

            // Convertir los parámetros a sus tipos correspondientes
            int productValue = Integer.parseInt(productValueString);
            int categoryId = Integer.parseInt(categoryIdString);

            // Crear una instancia del producto con los parámetros obtenidos
            Product product = new Product(null, productName, productValue, categoryId);

            // Guardar el producto en la base de datos utilizando el repositorio
            productRepository.saveObj(product);

            // Redireccionar a una página de éxito o mostrar un mensaje de éxito
            response.sendRedirect("success.jsp");
        } catch (NumberFormatException e) {
            throw new ServletException("Error al procesar la solicitud: los valores proporcionados no son válidos", e);
        } catch (SQLException e) {
            throw new ServletException("Error al registrar el producto", e);
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
