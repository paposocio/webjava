<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de control</title>
    <link rel="icon" type="image/x-icon" href="../images/icon.png">
    <link rel="stylesheet" href="../css/catpro.css">
    <link href='https://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
    <header class="header-fixed">

        <div class="header-limiter">

            <h1><a href="#">My<span>App</span></a></h1>

            <nav>
                <a href="#">Home</a>
                <a href="#">Blog</a>
                <a href="#">Pricing</a>
                <a href="#">About</a>
                <a href="#">Faq</a>
                <a href="#">Contact</a>
            </nav>

        </div>

    </header>
    <section class="header">
        <img src="../images/icon.png" alt="logo" width="7%">
    </section>


    <section class="loginContainer">
        <h1 class="text-secondary">Registro Categorias</h1>
        <form class="row g-3" action="../register-category" method="post">
            <div class="col-auto">
                <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Categoria nueva:">
            </div>
            <div class="col-auto">
                <input type="text" class="form-control" name="category_name" required>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">Agregar</button>
            </div>
        </form>

    </section>
    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <h6>Acerca de</h6>
                    <p class="text-justify">java.com <i>Ejemplo </i> Lorem ipsum dolor sit amet, consectetur
                        adipiscing elit. Fusce volutpat quam lectus, sit amet rutrum lectus hendrerit efficitur.
                        Proin convallis nulla eget ultricies viverra. Cras pulvinar metus eros, ac accumsan
                        magna egestas et. Nulla aliquam, ipsum nec pulvinar pharetra, est purus mattis risus,
                        vel posuere est metus eget orci. Proin fermentum elementum velit ultricies venenatis. Ut
                        venenatis faucibus tellus at ullamcorper. Duis ut risus enim.</p>
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
                    <p class="copyright-text" id="copy">© <%= java.time.Year.now().getValue() %> - Todos los
                            derechos
                            reservados.</p>
                    </p>
                </div>

            </div>
        </div>
    </footer>
</body>

</html>