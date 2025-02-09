<%-- 
    Document   : Index
    Created on : 9/02/2025, 1:34:32 p. m.
    Author     : ielcj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilos.css">
        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body class="bodysami">
        <div>
            <form action="Validar" method="POST">
                <div class="inicio">
                    <div class="logueo">

                         
               
                    <div class="formulario">
                            <h3>Login</h3>
                            <div class="input-box">
                            <span class="icon">
                                <ion-icon name="mail"></ion-icon>
                            </span>
                            <input type="text" name="txtuser" required>
                            <label>Usuario:</label>
                            </div>
                            <div class="input-box">
                            <span class="icon">   
                            <ion-icon name="lock"></ion-icon>
                            </span>
                            <input type="password" name="txtpass" required >
                            <label>Password:</label>
                            </div>
                        
                        <button class="btn-ingresar"type="submit" name="accion" value="Ingresar">Ingresar</button>
                       
                    </div>
                    
                    </div>
                </div>
                
            </form>
        </div>
        
        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>

    </body>
</html>
