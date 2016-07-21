<%@page import="center.CenterHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="center.CenterBeans"%>
<%
    CenterHelper ch = CenterHelper.getInstance();
    HttpSession hs = request.getSession();
    CenterBeans cb = (CenterBeans)hs.getAttribute("con");
    ArrayList<String> chkList = cb.conproperties();
    
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
        <% if(chkList.size()==0){ %>
        <h1>内容確認</h1>
        名前名:<br><%= cb.getName()%><br><br>
        内容:<br><%= cb.getComment().replaceAll("\n","<BR>")%><br><br>
        上記の内容で送信します。よろしいですか？
        <form action="ContactResult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=ch.coninput(chkList) %>
    <% } %>
        <form action="Contact" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
        <%=ch.home()%>
        </div>
    </body>
</html>
