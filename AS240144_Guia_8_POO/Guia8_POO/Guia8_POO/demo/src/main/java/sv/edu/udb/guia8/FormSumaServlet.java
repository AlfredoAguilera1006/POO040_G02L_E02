package sv.edu.udb.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "FormSumaServlet", urlPatterns = {"/sumaServlet"})
public class FormSumaServlet extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest request,
                          final HttpServletResponse response)
            throws ServletException, IOException {

        final String num_1 = request.getParameter("num_1");
        final String num_2 = request.getParameter("num_2");

        try {
            final Double sum = sumNumbers(Double.valueOf(num_1),
                    Double.valueOf(num_2));
            request.setAttribute("respuesta", sum);
            request
                    .getRequestDispatcher("index.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            request
                    .getRequestDispatcher("index.jsp")
                    .forward(request, response);
        }
    }

    private Double sumNumbers(final Double num1, final Double num2) {
        return num1 + num2;
    }
}