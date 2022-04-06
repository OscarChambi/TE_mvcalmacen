<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Producto"%>
<%
    ArrayList<Producto> lista = (ArrayList<Producto>) session.getAttribute("listaproduc");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" align="center" cellspacing="0">
            <tr>
                <td><b>PRIMER PARCIAL TEM-742</b><br><b>Nombre</b>: Oscar Mollericona Chambi<br><b>Carnet</b>: 7074687</td>
            </tr>
        </table>
        <h1 align="center">Productos</h1>
        <a href="MainController?opcion=nuevo"> Nuevo Producto</a>
        <table border="1" cellpadding="0" cellspacing="1" align="center">

            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th>Editar Registro</th>
                <th>Eliminar Registro</th>
            </tr>
            <%
                if (lista != null) {
                    for (Producto i : lista) {
            %>
            <tr>
                <td><%= i.getId()%></td>
                <td><%= i.getDescripcion()%></td>
                <td><%= i.getCantidad()%></td>
                <td><%= i.getPrecio()%></td> 
                <td><%= i.getCategoria()%></td> 
                <td align ="center"><a href="MainController?opcion=editar&id=<%=i.getId()%>">Editar</a> </td>
                <td align ="center"><a href="MainController?opcion=eliminar&id=<%=i.getId()%>" onclick="return confirm('Esta seguro de eliminar el registro?');">Eliminar</a> </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </body>
</html>
