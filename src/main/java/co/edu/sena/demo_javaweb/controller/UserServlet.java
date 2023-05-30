package co.edu.sena.demo_javaweb.controller;

import co.edu.sena.demo_javaweb.model.beans.User;
import co.edu.sena.demo_javaweb.model.repository.Repository;
import co.edu.sena.demo_javaweb.model.repository.UserRepositoryImpl;
import co.edu.sena.demo_javaweb.util.ConnectionPool;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/register-user")
public class UserServlet extends HttpServlet {
    private Repository<User> userRepository;

    @Override
    public void init() throws ServletException {
        try {
            // Crear una instancia del repositorio de usuarios
            userRepository = new UserRepositoryImpl();
        } catch (Exception e) {
            throw new ServletException("Error al inicializar el repositorio de usuarios", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del usuario enviados desde el formulario
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Crear una instancia del usuario con los datos obtenidos
            User user = new User(firstName, lastName, email, password);

            // Guardar el usuario en la base de datos utilizando el repositorio
            try {
                userRepository.saveObj(user);
            } catch (SQLException e) {
                throw new ServletException("Error al registrar el usuario", e);
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
