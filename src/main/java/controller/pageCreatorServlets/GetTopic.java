package controller.pageCreatorServlets;

import model.database.TopicsDatabase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetTopic", value = "/GetTopic")
public class GetTopic extends HttpServlet { // сервлет дістає тему з бази даних та перенаправляє запит до сторінки теми
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer topicId = Integer.parseInt(request.getParameter("topicId"));
        request.getSession().setAttribute("currentTopic", TopicsDatabase.getTopic(topicId));
        request.getRequestDispatcher("WEB-INF/pages/topicPage.jsp").forward(request, response);
    }
}
