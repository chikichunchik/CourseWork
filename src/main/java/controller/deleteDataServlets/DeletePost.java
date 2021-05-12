package controller.deleteDataServlets;

import model.elements.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePost", value = "/DeletePost")
public class DeletePost extends HttpServlet { // сервлет видаляє допис у темі
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer postId = Integer.parseInt(request.getParameter("postId"));
        Topic currentTopic = (Topic) request.getSession().getAttribute("currentTopic");
        currentTopic.deletePost(postId);
        request.getRequestDispatcher("WEB-INF/pages/topicPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
