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
    <meta name="keywords"
      content="registro de usuario, formulario de registro , acceso,login,sign up,registro en linea">
    <link rel="icon" type="image/x-icon" href="images/icon.png">
    <link rel="stylesheet" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
      integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
  </head>

  <body>
    <header class="header-fixed">

      <div class="header-limiter">

        <h1><a href="${pageContext.request.contextPath}/redirection?page=start">My<span>App</span></a></h1>

        <nav>
          <a href="redirection?page=products">Registro productos</a>
          <a href="redirection?page=categories">Registro categoria</a>
        </nav>

      </div>

    </header>
    <section class="header">
      <img src="images/icon.png" alt="logo" width="7%">
      <h1 class="text-secondary">MyApp</h1>
    </section>

    <section class="loginContainer">
      <div class="login-page">
        <div class="form">
          <form class="register-form" action="${pageContext.request.contextPath}/register-user" method="post">
            <input type="text" name="firstName" id="firstName" placeholder="Primer nombre" required autofocus
              pattern="[A-Zz-z]+{2,40}">
            <input type="text" name="lastName" id="lastName" placeholder="Primer apellido" required
              pattern="[A-Zz-z]+{2,40}">
            <input type="email" name="email" id="email" placeholder="Correo electronico" required pattern="{,60}">
            <input type="password" name="password" id="password" placeholder="Contraseña" required
              pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\da-zA-Z]).{8,}">
            <button>Crear</button>
            <p class="message">¿Registrado? <a href="#">Inicia sesion</a></p>
          </form>

          <form class="login-form" action="" method="post">
            <input type="email" name="email" id="email" placeholder="Correo electronico" required pattern="{,60}">
            <input type="password" name="password" id="password" placeholder="Contraseña" required
              pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\da-zA-Z]).{8,}">
            <button>Iniciar</button>
            <p class="message">¿Sin registrar? <a href="#">Crea una cuenta</a></p>
          </form>

        </div>
      </div>
    </section>
  </body>
  <footer class="site-footer">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-md-6">
          <h6>Acerca de</h6>
          <p class="text-justify">java.com <i>Ejemplo </i> Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Fusce volutpat quam lectus, sit amet rutrum lectus hendrerit efficitur. Proin convallis nulla eget ultricies
            viverra. Cras pulvinar metus eros, ac accumsan magna egestas et. Nulla aliquam, ipsum nec pulvinar pharetra,
            est purus mattis risus, vel posuere est metus eget orci. Proin fermentum elementum velit ultricies
            venenatis. Ut venenatis faucibus tellus at ullamcorper. Duis ut risus enim.</p>
        </div>

        <div class="col-xs-6 col-md-3">
          <h6>Categorias</h6>
          <ul class="footer-links">
            <li><a href="#">A</a></li>
            <li><a href="#">B</a></li>
            <li><a href="#">C</a></li>
            <li><a href="#">D</a></li>
            <li><a href="#">E</a></li>
            <li><a href="#">F</a></li>
          </ul>
        </div>

        <div class="col-xs-6 col-md-3">
          <h6>Enlaces de interes</h6>
          <ul class="footer-links">
            <li><a href="#">About Us</a></li>
            <li><a href="#">Contact Us</a></li>
            <li><a href="#">Contribute</a></li>
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Sitemap</a></li>
          </ul>
        </div>
      </div>
      <hr>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-sm-6 col-xs-12">
          <p class="copyright-text" id="copy">© <%= java.time.Year.now().getValue() %> - Todos los derechos
              reservados.</p>
          </p>
        </div>

      </div>
    </div>
  </footer>

  </html>
  <script>$('.message a').click(function () { $('form').animate({ height: "toggle", opacity: "toggle" }, "slow"); });</script>