package controller.deleteDataServlets;

import model.database.TopicsDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTopic", value = "/DeleteTopic")
public class DeleteTopic extends HttpServlet { // сервелет видаляє тему
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer topicId = Integer.parseInt(request.getParameter("topicId"));
        TopicsDatabase.deleteTopic(topicId);
        response.sendRedirect("main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
