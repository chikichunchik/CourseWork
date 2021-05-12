package controller.pageCreatorServlets;

import model.database.TopicsDatabase;
import model.database.UsersDatabase;
import model.elements.Topic;
import model.users.Administrator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(name = "Main", value = "/Main")
public class Main extends HttpServlet { // сервлет дістає з бази даних усі теми та перенаправляє запит на головну сторінку
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Topic> topics = TopicsDatabase.getDatabase().values();
        request.setAttribute("topics", topics);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
