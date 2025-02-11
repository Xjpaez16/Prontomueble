<%-- 
    Document   : Clientes
    Created on : 9/02/2025, 4:05:24 p. m.
    Author     : ielcj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilocliente.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>VENDEDOR</title>
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
                        <h5>Formulario Vendedor</h5>
                    </div>
                    <div class="card-body">
                        <form action="Catalogo?menu=Vendedor" method="POST">
                            <div class="mb-3">
                                <label class="form-label">ID</label>
                                <input type="text" value="${vendedor.getId()}" name="txtId" class="form-control" placeholder="Ingrese ID" required ${not empty vendedor.getId() ? 'readonly' : ''}>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Nombre</label>
                                <input type="text" value="${vendedor.getNombre()}" name="txtNombre" class="form-control" placeholder="Ingrese nombre" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">User</label>
                                <input type="text" value="${vendedor.getUsuario()}" name="txtUser" class="form-control" placeholder="Ingrese usuario" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Clave</label>
                                <input type="password" value="${vendedor.getClave()}" name="txtClave" class="form-control" placeholder="Ingrese clave" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Telefonos</label>

                              
                                <input type="text" value="${vendedor.getTelefonos().size() > 0 ? vendedor.getTelefonos().get(0).getnTelefono() : ''}" 
                                       name="txtTelefono" class="form-control mb-2" placeholder="Ingrese teléfono" required>

                        
                                <input type="text" value="${vendedor.getTelefonos().size() > 1 ? vendedor.getTelefonos().get(1).getnTelefono() : ''}" 
                                       name="txtTelefono" class="form-control mb-2" placeholder="Ingrese teléfono">
                                
                            </div>
                            <div class="d-flex justify-content-between">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-primary w-60">Agregar</button>
                                <button type="submit" name="accion" value="Actualizar" class="btn btn-success w-60">Actualizar</button>
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
                                                        <th>#</th>
                                                        <th>NOMBRES</th>
                                                        <th>USER</th>
                                                        <th>CLAVE</th>
                  
                                                        <th>TELÉFONOS</th>
                                                        <th>ACCIONES</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="vendedor" items="${listaVendedores}">
                                                    <tr>
                                                        <td class="text-center">${vendedor.getId()}</td>
                                                        <td>${vendedor.getNombre()}</td>
                                                        <td>${vendedor.getUsuario()}</td>
                                                        <td>${vendedor.getClave()}</td>
                                                  
                                                        <td>
                                                    <c:forEach var="telefono" items="${vendedor.getTelefonos()}">
                                                        ${telefono.getnTelefono()}<br>
                                                    </c:forEach>
                                                    </td>
                                                    <td>
                                                        <a class="Btnedit" href="Catalogo?menu=Vendedor&accion=Editar&id=${vendedor.getId()}">Editar
                                                            <svg viewBox="0 0 512 512" class="svg">
                                                            <path
                                                                d="M410.3 231l11.3-11.3-33.9-33.9-62.1-62.1L291.7 89.8l-11.3 11.3-22.6 22.6L58.6 322.9c-10.4 10.4-18 23.3-22.2 37.4L1 480.7c-2.5 8.4-.2 17.5 6.1 23.7s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L387.7 253.7 410.3 231zM160 399.4l-9.1 22.7c-4 3.1-8.5 5.4-13.3 6.9L59.4 452l23-78.1c1.4-4.9 3.8-9.4 6.9-13.3l22.7-9.1v32c0 8.8 7.2 16 16 16h32zM362.7 18.7L348.3 33.2 325.7 55.8 314.3 67.1l33.9 33.9 62.1 62.1 33.9 33.9 11.3-11.3 22.6-22.6 14.5-14.5c25-25 25-65.5 0-90.5L453.3 18.7c-25-25-65.5-25-90.5 0zm-47.4 168l-144 144c-6.2 6.2-16.4 6.2-22.6 0s-6.2-16.4 0-22.6l144-144c6.2-6.2 16.4-6.2 22.6 0s6.2 16.4 0 22.6z"
                                                                ></path>
                                                            </svg></a>                                                                                   
                                                        <a class="button" type="button" href="Catalogo?menu=Vendedor&accion=Delete&id=${vendedor.getId()}"><span class="button__text">Delete</span>
                                                            <span class="button__icon"><svg class="svg" height="512" viewBox="0 0 512 512" width="512" xmlns="http://www.w3.org/2000/svg"><title></title><path d="M112,112l20,320c.95,18.49,14.4,32,32,32H348c17.67,0,30.87-13.51,32-32l20-320" style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"></path><line style="stroke:#fff;stroke-linecap:round;stroke-miterlimit:10;stroke-width:32px" x1="80" x2="432" y1="112" y2="112"></line><path d="M192,112V72h0a23.93,23.93,0,0,1,24-24h80a23.93,23.93,0,0,1,24,24h0v40" style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px"></path><line style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px" x1="256" x2="256" y1="176" y2="400"></line><line style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px" x1="184" x2="192" y1="176" y2="400"></line><line style="fill:none;stroke:#fff;stroke-linecap:round;stroke-linejoin:round;stroke-width:32px" x1="328" x2="320" y1="176" y2="400"></line></svg></span></a>
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
