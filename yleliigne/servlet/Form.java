package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FormData;
import beans.Person;

public class Form extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        showForm(request, response);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1, "Laps");
        map.put(2, "Täiskasvanu");
        map.put(3, "Pensionär");
        FormData formData = new FormData();
        formData.setAgeGroups(map);

        request.setAttribute("formData", formData);
        request.getRequestDispatcher("WEB-INF/jsp/form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        List<String> errors = getValidationErrors(request);
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            showForm(request, response);
            return;
        }

        Person person = new Person();
        person.setName(request.getParameter("name"));
        person.setFirstName(request.getParameter("firstName"));
        person.setAgeGroupId(Integer.parseInt(request.getParameter("ageGroupId")));

        request.getSession().setAttribute("person", person);

        response.sendRedirect("Summary");
    }

    private List<String> getValidationErrors(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        if ("".equals(request.getParameter("firstName"))) {
            errors.add("Sisesta eesnimi!");
        }
        if ("".equals(request.getParameter("name"))) {
            errors.add("Sisesta perekonnanimi!");
        }

        return errors;
    }

}
