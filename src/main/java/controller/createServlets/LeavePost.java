package controller.createServlets;

import model.elements.Post;
import model.elements.Topic;
import model.users.CommonUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LeavePost", value = "/LeavePost")
public class LeavePost extends HttpServlet { // сервлет перевіряє введені дані та записує новий допис у тему
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("usersMessage").isEmpty()){
            ArrayList<String> errorMessages = new ArrayList<>();
            errorMessages.add("Fill message field");
            request.setAttribute("errorMessages", errorMessages);
            request.getRequestDispatcher("WEB-INF/pages/topicPage.jsp").forward(request, response);
        } else {
            Topic currentTopic = (Topic) request.getSession().getAttribute("currentTopic");
            currentTopic.addPost(new Post(request.getParameter("usersMessage")
                    , (CommonUser) request.getSession().getAttribute("role")));
            request.getRequestDispatcher("WEB-INF/pages/topicPage.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
