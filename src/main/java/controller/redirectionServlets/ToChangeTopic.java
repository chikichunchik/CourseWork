package controller.redirectionServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToChangeTopic", value = "/ToChangeTopic")
public class ToChangeTopic extends HttpServlet { // сервлет перенапрявляє запит на сторінку редактування теми
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/changeTopicPage.jsp").forward(request, response);
    }
}
