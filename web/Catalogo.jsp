<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <form action="Catalogo" method="POST">
            <a href="Catalogo?menu=catalogo"> <img src="img/logo.png" class="logo"> </a>
        </form>
        <input type="checkbox" id="check">
        <label for="check" class="mostrar-menu">
           
        </label>
        <nav class="menu">
            <ul>
                
                <li><a href="Catalogo?menu=Cliente&accion=Listar">Clientes</a></li>
                <li><a href="Catalogo?menu=Proveedor&accion=Listar">Proveedores</a></li>
                <li><a href="Catalogo?menu=Vendedor&accion=Listar">Vendedores</a></li>
                <li><a href="Catalogo?menu=Mueble&accion=Listar">Mueble</a></li>
            </ul>
                <label for="check" class="esconder-menu">
               
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
            <c:forEach var="mueble" items="${muebles}">
                
                <div class="item">
                    <figure>
                        <img src="${mueble.url}" alt="${mueble.nombre}">
                    </figure>
                    <div class="info-producto">
                        
                        <h2>${mueble.nombre}</h2>
                        <p class="precio">$ <c:out value="${mueble.precio}" /></p>
                        <p>Material: <c:out value="${mueble.material}" /></p>
                        <p>Color: <c:out value="${mueble.color}" /></p>
                        <p>Dimensiones: ${mueble.alto} x ${mueble.ancho} x ${mueble.profundidad} cm</p>
                        <button class="boton">
                            <a href="detalles.jsp?referencia=${mueble.referencia}">Ver producto</a>
                        </button>
                    </div>
                </div>
            </c:forEach>
     
        </div>
    </section>
    <script src="script.js" defer></script>
    <script src="index.js"></script>
</body>
</html>