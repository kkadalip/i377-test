package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.TableRow;

public class Tables extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("rowsKey1", Arrays.asList(
                new TableRow("1", "Tiit Tamm"),
                new TableRow("2", "Margus Kask")));

        request.setAttribute("rowsKey2", Arrays.asList(
                new TableRow("1", "Põder"),
                new TableRow("2", "Karu")));

        request.getRequestDispatcher("WEB-INF/jsp/tables.jsp").forward(request, response);
    }

}
