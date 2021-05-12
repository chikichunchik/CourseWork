<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sign In Page</title>
    </head>
    <body>

    <!-- Форма для входу до акаунту -->
    <form action="SignIn" method="post">
        Input nickname: <input type="text" name="nickname"/> <br>
        Input password: <input type="password" name="password"/> <br>
        <input type="submit" value="Sign In">
    </form>

    <!-- Вивід повідомлень, якщо такі є -->
    <%if(request.getAttribute("errorMessage") != null){
        for(String message : (ArrayList<String>) request.getAttribute("errorMessage")) {%>
    <%=message%> <br>
    <% } }%>

    <!-- Кнопки для реєстрації та входу як гість -->
    <form action="ToRegister" method="get">
        <input type="submit" value="To register page">
    </form>

    <form action="AsGuest" method="post">
        <input type="submit" value="Continue as a guest">
    </form>

    </body>
</html>
