package controller.createServlets;

import model.database.TopicsDatabase;
import model.elements.Topic;
import model.users.Administrator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CreateTopic", value = "/CreateTopic")
public class CreateTopic extends HttpServlet { // сервелт перевіряє введені дані та створює нову тему
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> messages = new ArrayList<>();
        if(request.getParameter("theme") != null && !request.getParameter("startMessage").isEmpty()) {
            TopicsDatabase.addTopic(new Topic(request.getParameter("theme")
                    , request.getParameter("startMessage")
                    , (Administrator) request.getSession().getAttribute("role")));
            messages.add("Topic successfully added");
        } else {
            messages.add("Fill all fields");
        }
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("WEB-INF/pages/createTopicPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
