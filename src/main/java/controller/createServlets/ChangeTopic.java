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

@WebServlet(name = "ChangeTopic", value = "/ChangeTopic")
public class ChangeTopic extends HttpServlet { // сервлет перевіряє введені дані та змінює тему
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> messages = new ArrayList<>();
        if(request.getParameter("theme") != null && !request.getParameter("startMessage").isEmpty()) {
            ((Topic) request.getSession().getAttribute("currentTopic"))
                    .setTheme(request.getParameter("theme"));
            ((Topic) request.getSession().getAttribute("currentTopic"))
                    .setStartMessage(request.getParameter("startMessage"));
            messages.add("Topic successfully changed");
        } else {
            messages.add("Fill all fields");
        }
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("WEB-INF/pages/changeTopicPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
