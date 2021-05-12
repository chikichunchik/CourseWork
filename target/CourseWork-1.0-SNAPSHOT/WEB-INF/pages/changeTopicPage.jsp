<%@ page import="java.util.ArrayList" %>
<%@ page import="model.elements.Topic" %>
<%@ page import="model.users.CommonUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Change Topic</title>
    </head>
    <body>

        <!-- Верхнє віконце що відображає ім'я користувача та пропонує увійти гостю та вийти зареєстрованому користувачу -->
        <div align="right">
            <p> You logged as <%=((CommonUser) request.getSession().getAttribute("role")).getName()%> </p>
            <% if(request.getSession().getAttribute("role") == null
                    || !(request.getSession().getAttribute("role") instanceof CommonUser)) { %>
            <form action="ToSignIn", method="get">
                <input type="submit" value="Sing in">
            </form>
            <% } else { %>
            <form action="LogOut", method="post">
                <input type="submit" value="Log out">
            </form>
            <% } %>
        </div>

        <!-- Форма для зміни теми -->
        <form action="ChangeTopic", method="post">
            Input new theme: <input type="text" name="theme"
                                value="<%=((Topic) request.getSession().getAttribute("currentTopic")).getTheme()%>" >
            <br>
            Input new start message: <textarea name="startMessage" cols="40" rows="3"
                                               placeholder = "<%=((Topic) request.getSession().getAttribute("currentTopic")).getStartMessage()%>"></textarea>
            <br>
            <input type="submit" value="Change">
        </form>

        <form action="ToTopic", method="get">
            <input type="submit" value="Back to topic page">
        </form>

        <!-- Вивід повідомлень, якщо такі є -->
        <br>
        <% if(request.getAttribute("messages") != null){ %>
            <%for(String message : (ArrayList<String>) request.getAttribute("messages")){%>
                <%=message%>
                <br>
            <%}%>
        <%}%>
    </body>
</html>