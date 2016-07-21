<%@page import="java.util.ArrayList"%>
<%@page import="center.CenterBeans"%>
<%@page import="center.CenterHelper"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    CenterBeans cb = (CenterBeans)request.getAttribute("con");   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
        <h1>送信結果</h1>
        名前:<br><%= cb.getName()%><br><br>
        内容:<br><%= cb.getComment().replaceAll("\n","<BR>")%><br><br>
        上記の内容で送信しました。<br>
        
        <%=ch.home()%>
        </div>
    </body>
</html>
