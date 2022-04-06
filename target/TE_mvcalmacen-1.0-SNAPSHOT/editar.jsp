<%@page import="com.emergentes.modelo.Producto"%>
<%
    Producto item = (Producto) request.getAttribute("producto");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= (item.getId() == 0 ? "NUEVO PRODUCTO" : "EDITAR  PRODUCTO")%></h1>
        <form action="MainController" method="post">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <table>
                <tr>
                    <td>Descripción: </td>
                    <td><input type="text" name="descripcion" value="<%=item.getDescripcion()%>" required></td>
                </tr>
                <tr>
                    <td>Cantidad: </td>
                    <td><input type="number" name="cantidad" value="<%=item.getCantidad()%>" required></td>
                </tr>
                <tr>
                    <td>Precio: </td>
                    <td><input type="float" name="precio" value="<%=item.getPrecio()%>" required></td>
                </tr>
                <tr>
                    <td>Categoría: </td>
                    <td><input type="text" name="categoria" value="<%=item.getCategoria()%>" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="ENVIAR"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
