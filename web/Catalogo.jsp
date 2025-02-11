<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="shortcut icon" href="img/logo.png" type="image/x-icon">
    <script src="https://kit.fontawesome.com/2a556287ee.js" crossorigin="anonymous"></script>
    <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
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
                <li><a href="Catalogo?menu=Reporte">REGISTRO FACTURA</a></li>
                <li>
                    <a onclick="toggleCarrito()">
                        <ion-icon name="cart"></ion-icon> <span id="contador-carrito">( ${sessionScope.carrito.size()} )</span>
                    </a>
               

                        <div id="carrito-sidebar" class="carrito-sidebar">
                            <div class="carrito-header">
                                <h2>Carrito de Compras</h2>
                                <button class="cerrar-carrito" onclick="toggleCarrito()">✖</button>
                            </div>
                            <div class="carrito-contenido">
                                <ul>
                                    <c:forEach var="producto" items="${sessionScope.carrito}">
                                        <li>
                                            <img src="${producto.url}" alt="${producto.nombre}" width="550px" height="350px">
                                            <span>${producto.nombre} - $${producto.precio}</span>
                                            <a href="Catalogo?menu=Aggcarrito&accion=EliminarCarrito&id=${producto.referencia}">❌</a>
                                        </li>
                                    </c:forEach>
                                        <form class="tupapa" action="Catalogo?menu=GenerarVenta" method="POST"><button class="cta" type="submit" name="accion" value="GenerarVenta">
                                                <span class="hover-underline-animation"> Comprar ahora </span>
                                                <svg
                                                    id="arrow-horizontal"
                                                    xmlns="http://www.w3.org/2000/svg"
                                                    width="30"
                                                    height="10"
                                                    viewBox="0 0 46 16"
                                                    >
                                                <path
                                                    id="Path_10"
                                                    data-name="Path 10"
                                                    d="M8,0,6.545,1.455l5.506,5.506H-30V9.039H12.052L6.545,14.545,8,16l8-8Z"
                                                    transform="translate(30)"
                                                    ></path>
                                                </svg>
                                            </button>
                                        </form>
                                </ul>
                            </div>
                        </div></li>
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
                        <p>Stock: <c:out value="${mueble.cantidad}" /></p>
                        <button class="boton">
                            <a href="Catalogo?menu=Aggcarrito&accion=Carrito&id=${mueble.referencia}">Agregar al carrito</a>
                        </button>
                    </div>
                </div>
            </c:forEach>
     
        </div>
    </section>
    
    <script src="js/index.js"></script>
    <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
</body>
</html>