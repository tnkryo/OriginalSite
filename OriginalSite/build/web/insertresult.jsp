<%@page import="java.util.ArrayList"%>
<%@page import="center.CenterBeans"%>
<%@page import="center.CenterHelper"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    CenterBeans cb = (CenterBeans)request.getAttribute("cb");   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録結果</title>
    </head>
    <body>
        <div align="center">
        <h1>登録結果</h1>
        店舗名:<%= cb.getName()%><br><br>
        住所:<%= cb.getJusyo()%><br><br>
        <%=ch.input(cb)%>
        上記の内容で登録しました。<br>
        
        <%=ch.contact()%> <%=ch.home()%>
        </div>
    </body>
</html>
