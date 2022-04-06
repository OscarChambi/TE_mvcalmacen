package com.emergentes.controlador;

import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Producto product = new Producto();
        if (sesion.getAttribute("listaproduc") == null) {
            ArrayList<Producto> listados = new ArrayList<Producto>();
            sesion.setAttribute("listaproduc", listados);
        }
        ArrayList<Producto> lista = (ArrayList<Producto>) sesion.getAttribute("listaproduc");
        String opciones = request.getParameter("opcion");
        String opcion = (opciones != null) ? opciones : "view";
        int id, posicion;
        switch (opcion) {
            case "nuevo":
                request.setAttribute("producto", product);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                posicion = BuscarIndice(request, id);
                product = lista.get(posicion);
                request.setAttribute("producto", product);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                posicion = BuscarIndice(request, id);
                lista.remove(posicion);
                sesion.setAttribute("listaproduc", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) sesion.getAttribute("listaproduc");
        Producto producto = new Producto();
        producto.setId(Integer.parseInt(request.getParameter("id")));
        producto.setDescripcion(request.getParameter("descripcion"));
        producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        producto.setPrecio(Float.parseFloat(request.getParameter("precio")));
        producto.setCategoria(request.getParameter("categoria"));
        int idaux = producto.getId();
        if (idaux == 0) {
            int ultimoid = BuscarUltimo(request);
            producto.setId(ultimoid);
            lista.add(producto);
        } else {
            lista.set(BuscarIndice(request, idaux), producto);
        }
        sesion.setAttribute("listaproduc", lista);
        response.sendRedirect("index.jsp");
    }

    private int BuscarIndice(HttpServletRequest request, int id) {
        int indice = 0;
        HttpSession ses = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("listaproduc");
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getId() == id) {
                    indice = i;
                }
            }
        }
        return indice;
    }

    private int BuscarUltimo(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Producto> lista = (ArrayList<Producto>) ses.getAttribute("listaproduc");
        int ida = 0;
        for (Producto i : lista) {
            ida = i.getId();
        }
        return ida + 1;
    }
}
