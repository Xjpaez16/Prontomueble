<%-- 
    Document   : Factura
    Created on : 10/02/2025, 6:06:59 p. m.
    Author     : ielcj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/styles.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>Factura</title>
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
                </ul>
                <label for="check" class="esconder-menu">

                </label>
            </nav>
        </header>
        <form class="card" action="Catalogo?menu=GenerarVenta" method="POST">      
        <div class="Container-card">
         
        <div class="card" >
        <c:forEach var="mueble" items="${sessionScope.carrito}">
        <li>
           
            <div class="container-img-info">
                <div class="img">
                   
                <img src="${mueble.url}" alt="${mueble.nombre}" width="450px" height="250px">
                <h2>${mueble.nombre}</h2> 
                <p>Material: <c:out value="${mueble.material}" /></p>
                <p>Color: <c:out value="${mueble.color}" /></p>
                <p>Dimensiones: ${mueble.alto} x ${mueble.ancho} x ${mueble.profundidad} cm</p>
                <p>Stock: <c:out value="${mueble.cantidad}" /></p>
                </div>
                <div class="info-mueble">
                
                <p class="precio">$<c:out value="${mueble.precio}"/></p>
                 <label for="cantidad">Cantidad:</label>
                 <input type="hidden" name="referencia" value="${mueble.referencia}">
                 <input type="number" name="cantidad" min="1" >
            
                
                </div>
              
            </div>
            <div  class="linea-div" ></div>    
        </li>
        </c:forEach>
       
        </div>
           
            
            <div class="card-body">
                <div class="mb-3">
                    
                    <h2>Datos Cliente</h2>
                    <label class="form-label">ID</label>
                    <input type="text" value="${cliente.getId()}" name="idCliente" class="form-control" placeholder="Ingrese ID" required >
                    <button class="button" name="accion" type="submit" value="Lcliente">
                        <div class="outline"></div>
                        <div class="state state--default">
                            <div class="icon">
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    fill="none"
                                    viewBox="0 0 24 24"
                                    height="1em"
                                    width="1em"
                                    >
                                <g style="filter: url(#shadow)">
                                <path
                                    fill="currentColor"
                                    d="M14.2199 21.63C13.0399 21.63 11.3699 20.8 10.0499 16.83L9.32988 14.67L7.16988 13.95C3.20988 12.63 2.37988 10.96 2.37988 9.78001C2.37988 8.61001 3.20988 6.93001 7.16988 5.60001L15.6599 2.77001C17.7799 2.06001 19.5499 2.27001 20.6399 3.35001C21.7299 4.43001 21.9399 6.21001 21.2299 8.33001L18.3999 16.82C17.0699 20.8 15.3999 21.63 14.2199 21.63ZM7.63988 7.03001C4.85988 7.96001 3.86988 9.06001 3.86988 9.78001C3.86988 10.5 4.85988 11.6 7.63988 12.52L10.1599 13.36C10.3799 13.43 10.5599 13.61 10.6299 13.83L11.4699 16.35C12.3899 19.13 13.4999 20.12 14.2199 20.12C14.9399 20.12 16.0399 19.13 16.9699 16.35L19.7999 7.86001C20.3099 6.32001 20.2199 5.06001 19.5699 4.41001C18.9199 3.76001 17.6599 3.68001 16.1299 4.19001L7.63988 7.03001Z"
                                    ></path>
                                <path
                                    fill="currentColor"
                                    d="M10.11 14.4C9.92005 14.4 9.73005 14.33 9.58005 14.18C9.29005 13.89 9.29005 13.41 9.58005 13.12L13.16 9.53C13.45 9.24 13.93 9.24 14.22 9.53C14.51 9.82 14.51 10.3 14.22 10.59L10.64 14.18C10.5 14.33 10.3 14.4 10.11 14.4Z"
                                    ></path>
                                </g>
                                <defs>
                                <filter id="shadow">
                                    <fedropshadow
                                        flood-opacity="0.5"
                                        stdDeviation="0.6"
                                        dy="1"
                                        dx="0"
                                        ></fedropshadow>
                                </filter>
                                </defs>
                                </svg>
                            </div>
                            <p>
                                <span style="--i:0">B</span>
                                <span style="--i:1">u</span>
                                <span style="--i:2">s</span>
                                <span style="--i:3">c</span>
                                <span style="--i:4">a</span>
                                <span style="--i:5">r</span>
                                
                            </p>
                        </div>
                        <div class="state state--sent">
                            <div class="icon">
                                <svg
                                    stroke="black"
                                    stroke-width="0.5px"
                                    width="1em"
                                    height="1em"
                                    viewBox="0 0 24 24"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                    >
                                <g style="filter: url(#shadow)">
                                <path
                                    d="M12 22.75C6.07 22.75 1.25 17.93 1.25 12C1.25 6.07 6.07 1.25 12 1.25C17.93 1.25 22.75 6.07 22.75 12C22.75 17.93 17.93 22.75 12 22.75ZM12 2.75C6.9 2.75 2.75 6.9 2.75 12C2.75 17.1 6.9 21.25 12 21.25C17.1 21.25 21.25 17.1 21.25 12C21.25 6.9 17.1 2.75 12 2.75Z"
                                    fill="currentColor"
                                    ></path>
                                <path
                                    d="M10.5795 15.5801C10.3795 15.5801 10.1895 15.5001 10.0495 15.3601L7.21945 12.5301C6.92945 12.2401 6.92945 11.7601 7.21945 11.4701C7.50945 11.1801 7.98945 11.1801 8.27945 11.4701L10.5795 13.7701L15.7195 8.6301C16.0095 8.3401 16.4895 8.3401 16.7795 8.6301C17.0695 8.9201 17.0695 9.4001 16.7795 9.6901L11.1095 15.3601C10.9695 15.5001 10.7795 15.5801 10.5795 15.5801Z"
                                    fill="currentColor"
                                    ></path>
                                </g>
                                </svg>
                            </div>
                            <p>
                                <span style="--i:5">.</span>
                                <span style="--i:6">.</span>
                                <span style="--i:7">.</span>
                                <span style="--i:8">.</span>
                            </p>
                        </div>
                    </button>
                  
                    <h2>Datos Vendedor</h2>
                    <label class="form-label">ID</label>
                    <input type="text" value="${usuario.getId()}" name="idVendedor" class="form-control" placeholder="Ingrese ID" ${not empty usuario.getId() ? 'readonly' : ''} >
                </div>
                
                <div class="mb-3">
                    <label class="form-label" id="lcliente">Nombre</label>
                    <input  id="cliente" type="text" value="${cliente.getNombre()}" name="txtNombre" class="form-control" placeholder="Ingrese nombre" ${not empty cliente.getId() ? 'readonly' : ''}>
                    <label class="form-label">Nombre</label>
                    <input type="text" value="${usuario.getNombre()}" name="txtNombre" class="form-control" placeholder="Ingrese nombre" ${not empty usuario.getId() ? 'readonly' : ''}>
                </div> 
                
                
            </div>
                 <button class="cta" name="accion" type="submit" value="GenerarFactura">

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
            
              
        </div>
     </form>
        
    </body>
</html>
