<%-- 
    Document   : Clientes
    Created on : 9/02/2025, 4:05:24 p. m.
    Author     : ielcj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilocliente.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>REPORTE VENTAS</title>
</head>
<body class="cliente">
    <header>
        <form action="Catalogo" method="POST">
            <a href="Catalogo?menu=catalogo"> <img src="img/logo.png" class="logo"> </a>
        </form>
        
        
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
    
    <div class="container mt-4">
        <div class="row">
            <div class="col-md-6">
                <div class="card shadow-lg">
                    <div class="card-header bg-black text-white text-center">
                        <h5>Formulario De Consulta</h5>
                    </div>
                    <div class="card-body">
                        <form action="Catalogo?menu=Reporte" method="POST">
                            <div class="mb-3">
                                <label class="form-label">Fecha Inicial</label>
                                <input type="date" name="txtFecha1" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Fecha Final</label>
                                <input type="date" name="txtFecha2" class="form-control" required>
                            </div>
                           
                            <div class="d-flex justify-content-between">
                                <button type="submit" name="accion" value="consultaFacfecha" class="btn btn-primary w-60">Agregar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
                                <div class="col-sm-12">
                                    <div class="card">
                                        <div class="card-body">
                                            
                                            <table class="table" style="width: 100%" id="clientesTable">
                                                <thead>
                                                    <tr class="text-center">
                                                        <th>ID</th>
                                                        <th>PRECIO</th>
                                                        <th>ID VENDEDOR</th>
                                                        <th>ID CLIENTE</th>
                                                        <th>FECHA VENTA</th>
                                                        <th>ID MUEBLE</th>
                                                        <th>CANTIDAD DE MUEBLES</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="factura" items="${facturas}">
                                                        <tr>
                                                            <!-- Mostrar los datos de cada factura -->
                                                            <td class="text-center">${factura.id}</td>
                                                            <td>${factura.precio}</td>
                                                            <td>${factura.id_v}</td>
                                                            <td>${factura.id_c}</td>
                                                            <td>${factura.fecha_venta}</td>
                                                            <td>
                                                                <!-- Mostrar referencias y cantidades -->
                                                                <c:forEach var="referencia" items="${factura.referencias}">
                                                                    ${referencia}
                                                                </c:forEach>
                                                            </td>
                                                            <td>
                                                                
                                                                    <c:forEach var="cantidad" items="${factura.cantidades}">
                                                                        ${cantidad}
                                                                    </c:forEach>
                                                              
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                       
        </div>
    </div>
    
</body>
