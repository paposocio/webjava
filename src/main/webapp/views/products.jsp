<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 20/05/2023
  Time: 10:52 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de control</title>
    <link rel="icon" type="image/x-icon" href="../images/icon.png">
    <link rel="stylesheet" href="../css/catpro.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>

<header>
    <img src="../images/icon.png" alt="logo" width="7%">
</header>

<section class="loginContainer">
    <h1 class="text-secondary">Productos</h1>
    <form class="row g-3" action="./controller/register-product" method="post">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Nombre del producto</label>
            <input type="text" class="form-control" name="productName" id="exampleFormControlInput1" required>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput2" class="form-label">Precio del producto</label>
            <input type="number" min="0" class="form-control" name="productValue" id="exampleFormControlInput2" required>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput3" class="form-label">Numero de la categoria</label>
            <input type="number" min="0" class="form-control" name="categoryId" id="exampleFormControlInput3" required>
        </div>
        <button type="submit" class="btn btn-primary mb-3">Agregar</button>
    </form>
    <p class="mt-3 mb-3 text-muted" id="copy">© <%= java.time.Year.now().getValue() %> - Todos los derechos reservados.</p>
</section>
</body>
</html>
