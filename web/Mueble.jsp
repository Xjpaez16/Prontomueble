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

    <title>MUEBLE</title>
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
                        <h5>Formulario Mueble</h5>
                    </div>
                    <div class="card-body">
                        <form action="Catalogo?menu=Mueble" method="POST">
                            <div class="mb-3">
                                <label class="form-label">REF</label>
                                <input type="text" value="${mueble.getReferencia()}" name="txtRef" class="form-control" placeholder="Ingrese REF" required ${not empty mueble.getReferencia() ? 'readonly' : ''}>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Nombre</label>
                                <input type="text" value="${mueble.getNombre()}" name="txtNombre" class="form-control" placeholder="Ingrese nombre" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Tipo</label>
                                
                                <select name="txtTipo" class="form-control mt-2" required>
                                    <option value="Cocina" ${mueble.getTipo() == "Cocina" ? "selected" : ""}>Cocina</option>
                                    <option value="Bano" ${mueble.getTipo() == "Bano" ? "selected" : ""}>Baño</option>
                                    <option value="Alcoba" ${mueble.getTipo() == "Alcoba" ? "selected" : ""}>Alcoba</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Alto</label>
                                <input type="text" value="${mueble.getAlto()}" name="txtAlto" class="form-control" placeholder="Ingrese alto" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Ancho</label>
                                <input type="text" value="${mueble.getAncho()}" name="txtAncho" class="form-control" placeholder="Ingrese ancho" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Profundidad</label>
                                <input type="text" value="${mueble.getProfundidad()}" name="txtProf" class="form-control" placeholder="Ingrese profundidad" required>
                            </div>
                                <div class="mb-3">
                                    <label class="form-label">Material</label>
                                   
                                    <select name="txtMat" class="form-control mt-2" required>
                                        <option value="Madera" ${mueble.getMaterial() == "Madera" ? "selected" : ""}>Madera</option>
                                        <option value="Metal" ${mueble.getMaterial() == "Metal" ? "selected" : ""}>Metal</option>
                                        <option value="Plastico" ${mueble.getMaterial() == "Plastico" ? "selected" : ""}>Plástico</option>
                                        <option value="Vidrio" ${mueble.getMaterial() == "Vidrio" ? "selected" : ""}>Vidrio</option>
                                        <option value="Cuero" ${mueble.getMaterial() == "Cuero" ? "selected" : ""}>Cuero</option>
                                        <option value="Tela" ${mueble.getMaterial() == "Tela" ? "selected" : ""}>Tela</option>
                                        <option value="Aluminio" ${mueble.getMaterial() == "Aluminio" ? "selected" : ""}>Aluminio</option>
                                        <option value="Hierro" ${mueble.getMaterial() == "Hierro" ? "selected" : ""}>Hierro</option>
                                        <option value="Bambu" ${mueble.getMaterial() == "Bambu" ? "selected" : ""}>Bambú</option>
                                        <option value="Acrilico" ${mueble.getMaterial() == "Acrilico" ? "selected" : ""}>Acrílico</option>
                                    </select>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Color</label>
                                   
                                    <select name="txtColor" class="form-control mt-2" required>
                                        <option value="Rojo" ${mueble.getColor() == "Rojo" ? "selected" : ""}>Rojo</option>
                                        <option value="Azul" ${mueble.getColor() == "Azul" ? "selected" : ""}>Azul</option>
                                        <option value="Verde" ${mueble.getColor() == "Verde" ? "selected" : ""}>Verde</option>
                                        <option value="Amarillo" ${mueble.getColor() == "Amarillo" ? "selected" : ""}>Amarillo</option>
                                        <option value="Negro" ${mueble.getColor() == "Negro" ? "selected" : ""}>Negro</option>
                                        <option value="Blanco" ${mueble.getColor() == "Blanco" ? "selected" : ""}>Blanco</option>
                                        <option value="Gris" ${mueble.getColor() == "Gris" ? "selected" : ""}>Gris</option>
                                        <option value="Marron" ${mueble.getColor() == "Marron" ? "selected" : ""}>Marrón</option>
                                        <option value="Beige" ${mueble.getColor() == "Beige" ? "selected" : ""}>Beige</option>
                                        <option value="Naranja" ${mueble.getColor() == "Naranja" ? "selected" : ""}>Naranja</option>
                                    </select>
                                </div>

                            <div class="mb-3">
                                <label class="form-label">Precio</label>
                                <input type="text" value="${mueble.getPrecio()}" name="txtPrice" class="form-control" placeholder="Ingrese precio" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Cantidad</label>
                                <input type="text" value="${mueble.getCantidad()}" name="txtCant" class="form-control" placeholder="Ingrese cantidad" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Url</label>
                                <div class="input-group">
                                    
                                    <c:if test="${not empty mueble.getUrl()}">
                                        <img src="${mueble.getUrl()}" alt="Imagen actual" class="img-thumbnail" style="max-width: 150px;">
                                    </c:if>
                                    <input type="file" name="txtUrl" class="form-control" accept="image/*" required>
                                </div>
                            </div>

                            <div class="d-flex justify-content-between ">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-dark">Agregar</button>
                                <button type="submit" name="accion" value="Actualizar" class="btn btn-secondary">Actualizar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
                          
                                <div class="col-sm-12">
                                    <div class="card">
                                        <div class="card-body">
                                            
                                            <table class="table scroll" style="width: 100%" id="clientesTable">
                                                <thead>
                                                    <tr class="text-center">
                                                        <th>REF</th>
                                                        <th>NOMBRE</th>
                                                        <th>TIPO</th>
                                                        <th>ALTO</th>
                                                        <th>ANCHO</th>
                                                        <th>PROFUNDIDAD</th>
                                                        <th>MATERIAL</th>
                                                        <th>COLOR</th>
                                                        <th>PRECIO</th>
                                                        <th>CANTIDAD</th>
                                                        <th>URL</th>
                                                        <th>ACCIONES</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="mueble" items="${lista}">
                                                    <tr>
                                                        <td class="text-center">${mueble.getReferencia()}</td>
                                                        <td>${mueble.getNombre()}</td>
                                                        <td>${mueble.getTipo()}</td>
                                                        <td>${mueble.getAlto()}</td>
                                                        <td>${mueble.getAncho()}</td>
                                                        <td>${mueble.getProfundidad()}</td>
                                                        <td>${mueble.getMaterial()}</td>
                                                        <td>${mueble.getColor()}</td>
                                                        <td>${mueble.getPrecio()}</td>
                                                        <td>${mueble.getCantidad()}</td>
                                                        <td>${mueble.getUrl()}</td>
                                                    <td>
                                                        <a class="Btnedit" href="Catalogo?menu=Mueble&accion=Editar&id=${mueble.getReferencia()}">Editar
                                                            <svg viewBox="0 0 512 512" class="svg">
                                                            <path
                                                                d="M410.3 231l11.3-11.3-33.9-33.9-62.1-62.1L291.7 89.8l-11.3 11.3-22.6 22.6L58.6 322.9c-10.4 10.4-18 23.3-22.2 37.4L1 480.7c-2.5 8.4-.2 17.5 6.1 23.7s15.3 8.5 23.7 6.1l120.3-35.4c14.1-4.2 27-11.8 37.4-22.2L387.7 253.7 410.3 231zM160 399.4l-9.1 22.7c-4 3.1-8.5 5.4-13.3 6.9L59.4 452l23-78.1c1.4-4.9 3.8-9.4 6.9-13.3l22.7-9.1v32c0 8.8 7.2 16 16 16h32zM362.7 18.7L348.3 33.2 325.7 55.8 314.3 67.1l33.9 33.9 62.1 62.1 33.9 33.9 11.3-11.3 22.6-22.6 14.5-14.5c25-25 25-65.5 0-90.5L453.3 18.7c-25-25-65.5-25-90.5 0zm-47.4 168l-144 144c-6.2 6.2-16.4 6.2-22.6 0s-6.2-16.4 0-22.6l144-144c6.2-6.2 16.4-6.2 22.6 0s6.2 16.4 0 22.6z"
                                                                ></path>
                                                            </svg></a>                                                                                   
                                                        <a class="button" type="button" href="Catalogo?menu=Mueble&accion=Delete&id=${mueble.getReferencia()}"><span class="button__text">Delete</span>
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
