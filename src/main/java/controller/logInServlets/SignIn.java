package controller.logInServlets;

import model.database.UsersDatabase;
import model.logIn.Authorization;
import model.users.CommonUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SignIn", value = "/SignIn")
public class SignIn extends HttpServlet { // сервелт перевіряє введені дані та здійснює вхід користувача у систему
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("nickname") == null || request.getParameter("password") == null){
            ArrayList<String> errorMessages = new ArrayList<>();
            errorMessages.add("Fill all fields");
            request.setAttribute("errorMessage", errorMessages);
            request.getRequestDispatcher("WEB-INF/pages/singInPage.jsp").forward(request, response);
        }
        boolean isNicknameCorrect = Authorization.isUserExists(request.getParameter("nickname"));
        if(!isNicknameCorrect){
            ArrayList<String> errorMessages = new ArrayList<>();
            errorMessages.add("Nickname is incorrect");
            request.setAttribute("errorMessage", errorMessages);
            request.getRequestDispatcher("WEB-INF/pages/singInPage.jsp").forward(request, response);
        }
        boolean isPasswordCorrect = Authorization.isPasswordCorrect(request.getParameter("nickname")
                , request.getParameter("password"));
        if(!isPasswordCorrect){
            ArrayList<String> errorMessages = new ArrayList<>();
            errorMessages.add("Password is incorrect");
            request.setAttribute("errorMessage", errorMessages);
            request.getRequestDispatcher("WEB-INF/pages/singInPage.jsp").forward(request, response);
        }
        request.getSession().setAttribute("role", UsersDatabase.getUser(request.getParameter("nickname")));
        response.sendRedirect("main.jsp");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
