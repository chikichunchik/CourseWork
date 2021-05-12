<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>
    </head>
    <body>

        <!-- Форма для реєстрації -->
        <form action="registration" method="post">
            Input nickname: <input type="text" name="nickname"/> <br>
            Input password: <input type="password" name="password"/> <br>
            <input type="submit" value="Register">
        </form>

        <!-- Вивід повідомлень, якщо такі є -->
        <%if(request.getAttribute("errorMessage") != null){
            for(String message : (ArrayList<String>) request.getAttribute("errorMessage")) {%>
            <%=message%> <br>
        <% } }%>

        <!-- Кнопки для входу до акаунту та входу як гість -->
        <form action="ToSignIn" method="get">
            <input type="submit" value="To Sign In page">
        </form>
        <form action="AsGuest" method="post">
            <input type="submit" value="Continue as a guest">
        </form>
    </body>
</html>
