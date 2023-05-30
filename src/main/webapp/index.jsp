<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario</title>
    <meta name="author" content="Sebastian Peña">
    <meta name="description" content="Acceda al sistema por medio de este portal">
    <meta name="keywords" content="registro de usuario, formulario de registro , acceso,login,sign up,registro en linea">
    <link rel="icon" type="image/x-icon" href="images/icon.png">
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>

<body>

<section class="header">
    <img src="images/icon.png" alt="logo" width="7%">
    <h1 class="text-secondary">MyApp</h1>
</section>
<%-- Redirección a la vista --%>
<% response.sendRedirect("views/products.jsp"); %>

<section class="loginContainer">
    <div class="login-page">
        <div class="form">
            <form class="register-form" action="register-user" method="post">
                <input type="text" name="firstName" id="firstName" placeholder="Primer nombre" required autofocus pattern="[A-Zz-z]+{2,40}">
                <input type="text" name="lastName" id="lastName" placeholder="Primer apellido"required pattern="[A-Zz-z]+{2,40}">
                <input type="email" name="email" id="email" placeholder="Correo electronico" required pattern="{,60}">
                <input type="password" name="password" id="password" placeholder="Contraseña" required pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\da-zA-Z]).{8,}">
                <button>Crear</button>
                <p class="message">¿Registrado? <a href="#">Inicia sesion</a></p>
            </form>

            <form class="login-form" action="" method="post">
                <input type="email" name="email" id="email" placeholder="Correo electronico" required pattern="{,60}">
                <input type="password" name="password" id="password" placeholder="Contraseña" required pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\da-zA-Z]).{8,}">
                <button>Iniciar</button>
                <p class="message">¿Sin registrar? <a href="#">Crea una cuenta</a></p>
            </form>

        </div>
    </div>
    <p class="mt-3 mb-3 text-muted" id="copy">© <%= java.time.Year.now().getValue() %> - Todos los derechos reservados.</p>
</section>
</body>
</html>
<script>$('.message a').click(function(){$('form').animate({height: "toggle", opacity: "toggle"}, "slow");});</script>