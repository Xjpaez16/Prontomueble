<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="shortcut icon" href="imagenes/loguito.png" type="image/x-icon">
    <script src="https://kit.fontawesome.com/2a556287ee.js" crossorigin="anonymous"></script>
    <title>Prontomueble</title>
</head>
<body>
    <header>
        <img class="logo" src="img/logo.png" alt="logo">
        <input type="checkbox" id="check">
        <label for="check" class="mostrar-menu">
            &#8801
        </label>
        <nav class="menu">
            <ul>
                <li><a href="index.html">Clientes</a></li>
                <li><a href="#Productos">Proovedores</a></li>
                <li><a href="sobren.html"></a></li>
            </ul>
                <label for="check" class="esconder-menu">
                    &#215
                </label>
        </nav>
    </header>
    <div class="div1"></div>
    <section>
        <div id="contenedorcarrusel">
            <div class="carruselitem" id="carruselitem1">
                <div class="tarjeta" id="a"><img src="img/nav1.png" alt="funko913"></div>
                <div class="flecha">
                    <a href="#carruselitem3"><i class="fa-solid fa-angle-left"></i></a>
                    <a href="#carruselitem2"><i class="fa-solid fa-angle-right"></i></a>
                </div>
            </div>
            <div class="carruselitem" id="carruselitem2">
                <div class="tarjeta" id="b"><img src="img/nav2.png" alt="escritorio"></div>
                <div class="flecha">
                    <a href="#carruselitem1"><i class="fa-solid fa-angle-left"></i></a>
                    <a href="#carruselitem3"><i class="fa-solid fa-angle-right"></i></a>
                </div>
            </div>
            <div class="carruselitem" id="carruselitem3">
                <div class="tarjeta"  id="c"><img src="img/nav3.png" alt="diademas"></div>
                <div class="flecha">
                    <a href="#carruselitem2"><i class="fa-solid fa-angle-left"></i></a>
                    <a href="#carruselitem1"><i class="fa-solid fa-angle-right"></i></a>
                </div>
            </div>
        </div>

    <div class="contenedorpuntos">
        <a href="#carruselitem1"><i class="fa-solid fa-circle"></i></a>
        <a href="#carruselitem2"><i class="fa-solid fa-circle"></i></a>
        <a href="#carruselitem3"><i class="fa-solid fa-circle"></i></a>
        
    </div> 
    </section>

    <section id="Productos">
        <div id="productos-container" class="container-item">
            <!-- Aquí se cargarán los productos dinámicamente -->
            <!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <c:forEach var="producto" items="${productos}">
                <div class="item">
                    <figure>
                        <img src="${producto.imagen}" alt="${producto.nombre}">
                    </figure>
                    <div class="info-producto">
                        <h2>${producto.nombre}</h2>
                        <p class="precio">$ <fmt:formatNumber value="${producto.precio}" type="currency" /></p>
                        <button class="boton" onclick="guardarProducto(${producto.id})">
                            <a href="${producto.enlace}">Ver producto</a>
                        </button>
                    </div>
                </div>
            </c:forEach>*/ -->

        </div>
    </section>
    <script src="script.js" defer></script>
    <script src="index.js"></script>
</body>
</html>