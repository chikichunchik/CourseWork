package controller.logInServlets;

import model.database.UsersDatabase;
import model.registration.Validation;
import model.users.CommonUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "registration", value = "/registration")
public class Registration extends HttpServlet { // сервлет перевіряє введені користувачем дані та реєструє його
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isPasswordAvailable = !request.getParameter("password").isEmpty()
                && Validation.isPasswordAvailable(request.getParameter("password"));
        boolean isNicknameAvailable = !request.getParameter("nickname").isEmpty()
                && Validation.isNicknameAvailable(request.getParameter("nickname"));
        if(!isNicknameAvailable || !isPasswordAvailable){
            ArrayList<String> errorMessages = new ArrayList<>();
            if(!isNicknameAvailable){
                errorMessages.add("Nickname is unavailable");
            }
            if(!isPasswordAvailable){
                errorMessages.add("Password must contain more than 7 symbols");
            }
            request.setAttribute("errorMessage", errorMessages);
            request.getRequestDispatcher("WEB-INF/pages/registrationPage.jsp").forward(request, response);
        } else {
            CommonUser newUser = new CommonUser(request.getParameter("nickname"), request.getParameter("password"));
            request.getSession().setAttribute("role", newUser);
            response.sendRedirect("main.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
